package fr.android.draymond.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.android.draymond.R;
import fr.android.draymond.model.Book;

public class BookItemView extends LinearLayout {

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public View bind(Book book) {
        ((TextView)findViewById(R.id.bookItemTitleTextView)).setText(book.getTitle());

        ImageView bookItemCover = (ImageView) findViewById(R.id.bookItemCoverImageView);
        Glide.with(this).load(book.getCover()).into(bookItemCover);

        return this;
    }
}
