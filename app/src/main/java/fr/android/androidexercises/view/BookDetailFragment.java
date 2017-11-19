package fr.android.androidexercises.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

        Bundle arguments = this.getArguments();
        Book book = arguments.getParcelable("book");
        fillBookDetailView(view, book);

        return view;
    }

    private void fillBookDetailView(View view, Book book) {

        ImageView bookCoverImage = view.findViewById(R.id.bookCoverImage);
        Glide.with(this).load(book.getCover()).into(bookCoverImage);

        TextView bookTitle = view.findViewById(R.id.bookTitle);
        bookTitle.setText(book.getTitle());

        TextView bookDescription = view.findViewById(R.id.bookDescription);
        String synopsis = book.getSynopsis().size() > 1 ? book.getSynopsis().get(0) : "No synopsis";
        bookDescription.setText(synopsis);

        TextView bookPrice = view.findViewById(R.id.bookPrice);
        bookPrice.setText(getString(R.string.currency, book.getPrice()));

        TextView bookISBN = view.findViewById(R.id.bookISBN);
        bookISBN.setText(getString(R.string.isbn, book.getIsbn()));

    }

}
