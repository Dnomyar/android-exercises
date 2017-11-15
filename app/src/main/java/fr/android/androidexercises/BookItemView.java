package fr.android.androidexercises;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookItemView extends LinearLayout {
    private TextView name;
    private TextView price;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        name = findViewById(R.id.nameTextView);
        price = findViewById(R.id.priceTextView);
    }

    public View bind(Book book) {
        name.setText(book.getTitle());
        price.setText(String.valueOf(book.getPrice()));

        return this;
    }
}
