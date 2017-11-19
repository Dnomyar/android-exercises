package fr.android.androidexercises.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;

/**
 * Created by damien on 15/11/2017.
 */

public class BookDetailFragment extends Fragment {

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_detail, container, false);

        fillBookDetailView(view);

        return view;
    }

    private void fillBookDetailView(View view) {
        TextView bookDescription = view.findViewById(R.id.bookDescription);

        Bundle arguments = this.getArguments();

        Book book = arguments.getParcelable("book");

        bookDescription.setText(book.getTitle());
    }

}
