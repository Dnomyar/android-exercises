package fr.android.androidexercises;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by damien on 15/11/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter {
    private final List<Book> collection;
    private final LayoutInflater inflater;
    private int resource;

    public RecyclerAdapter(LayoutInflater inflater, List<Book> collection, int resource) {
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
        ((BookItemView)holder.itemView).bind(this.collection.get(position));
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