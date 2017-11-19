package fr.android.androidexercises.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import fr.android.androidexercises.model.Book;


/**
 * Created by damien on 15/11/2017.
 */
public class BookListRecyclerAdapter extends RecyclerView.Adapter {
    private BookListFragment.BookListListener bookListListener;
    private final List<Book> books;
    private final LayoutInflater inflater;
    private int resource;

    public BookListRecyclerAdapter(BookListFragment.BookListListener bookListListener,
                                   LayoutInflater inflater,
                                   List<Book> books,
                                   int resource) {
        this.bookListListener = bookListListener;
        this.books = books;
        this.inflater = inflater;
        this.resource = resource;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(this.resource, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Book book = this.books.get(position);

        ((BookItemView) holder.itemView)
                .bind(book)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookListListener.onClickOnListItem(book);
                    }
                });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}