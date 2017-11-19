package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fr.android.androidexercises.view.BookDetailFragment;
import fr.android.androidexercises.view.BookListFragment;
import fr.android.androidexercises.model.Book;


public class LibraryActivity extends AppCompatActivity implements BookListFragment.BookListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //boolean isLandscape = getResources().getBoolean(R.bool.landscape);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, new BookListFragment(), "BookListFragment")
                .commit();
    }


    @Override
    public void onClickOnListItem(Book book) {

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);

        BookDetailFragment fragment = new BookDetailFragment();

        fragment.setArguments(bundle);

        transaction
                .replace(R.id.mainContainer, fragment, "BookDetailFragment")
                .addToBackStack(null)
                .commit();



    }
}
