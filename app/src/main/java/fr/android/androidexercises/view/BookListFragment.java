package fr.android.androidexercises.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import fr.android.androidexercises.Logger;
import fr.android.androidexercises.persistence.HenriPotierService;
import fr.android.androidexercises.persistence.HenriPotierServiceFactory;
import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by damien on 15/11/2017.
 */

public class BookListFragment extends Fragment {

    private BookListListener listener;
    private HenriPotierService henriPotierService;
    private List<Book> books = new LinkedList<>();

    private Logger logger = new Logger();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (BookListListener) context;
        this.henriPotierService = new HenriPotierServiceFactory().create();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_list_container, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.bookListContainer);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        final BookListRecyclerAdapter adapter = new BookListRecyclerAdapter(
                listener,
                LayoutInflater.from(view.getContext()),
                books,
                R.layout.book_list_item
        );


        recyclerView.setAdapter(adapter);


        henriPotierService.books().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                updateBookList(response, adapter);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                showEnableToGetBooksError(t);
            }
        });
    }

    private void showEnableToGetBooksError(Throwable t) {
        logger.error(t);

        Toast.makeText(
                (Context) listener,
                "An error occurred while getting books 😕",
                Toast.LENGTH_SHORT
        ).show();
    }

    private void updateBookList(Response<List<Book>> response, BookListRecyclerAdapter adapter) {
        logger.info("Got books");
        books.clear();
        books.addAll(response.body());
        adapter.notifyDataSetChanged();
    }

    public interface BookListListener {
        void onClickOnListItem(Book book);
    }
}
