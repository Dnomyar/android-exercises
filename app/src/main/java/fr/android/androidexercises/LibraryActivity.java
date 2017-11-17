package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.android.androidexercises.bookdetail.BookDetailFragment;
import fr.android.androidexercises.booklist.BookListFragment;


public class LibraryActivity extends AppCompatActivity implements BookListFragment.BookListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //boolean isLandscape = getResources().getBoolean(R.bool.landscape);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new BookListFragment(), "BookListFragment")
                //.replace(R.id.containerFrameLayout, new BookDetailFragment(), "BookDetailFragment")
                .commit();
    }


    @Override
    public void onClickOnListItem() {
        getSupportFragmentManager()
                .beginTransaction()
                //.replace(R.id.mainContainer, new BookListFragment(), "BookListFragment")
                .replace(R.id.containerFrameLayout, new BookDetailFragment(), "BookDetailFragment")
                .commit();
    }
}
