package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by damien on 15/11/2017.
 */

public class BookListFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_list_container, container, false);

        FragmentActivity activity = getActivity();
        RecyclerView recyclerView = view.findViewById(R.id.bookListView);


        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new RecyclerAdapter(
                inflater,
                getBooks(),
                R.layout.book_list_item
        ));

        return view;
    }



    private List<Book> getBooks() {
        Random random = new Random();
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            books.add(new Book(
                    String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                    Integer.toString(random.nextInt(30)))
            );
        }
        return books;
    }
}
