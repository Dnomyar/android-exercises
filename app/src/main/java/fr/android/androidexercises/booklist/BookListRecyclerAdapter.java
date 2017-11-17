package fr.android.androidexercises.booklist;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.android.androidexercises.booklist.BookItemView;
import fr.android.androidexercises.model.Book;


/**
 * Created by damien on 15/11/2017.
 */
public class BookListRecyclerAdapter extends RecyclerView.Adapter {
    private BookListFragment bookListFragment;
    private final List<Book> collection;
    private final LayoutInflater inflater;
    private int resource;

    public BookListRecyclerAdapter(BookListFragment bookListFragment,
                                   LayoutInflater inflater,
                                   List<Book> collection,
                                   int resource) {
        this.bookListFragment = bookListFragment;
        this.collection = collection;
        this.inflater = inflater;
        this.resource = resource;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(this.resource, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookItemView itemView = (BookItemView) holder.itemView;
        itemView.bind(this.collection.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookListFragment.onClickOnListItem();
            }
        });
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}