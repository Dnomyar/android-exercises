package fr.android.androidexercises.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;

public class BookItemView extends LinearLayout {
    private TextView title;
    private TextView price;
    private TextView description;
    private TextView isbn;

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
        ((TextView)findViewById(R.id.bookIemTitleTextView)).setText(book.getTitle());

        return this;
    }
}
