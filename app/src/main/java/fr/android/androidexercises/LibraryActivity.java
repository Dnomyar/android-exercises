package fr.android.androidexercises;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import fr.android.androidexercises.view.BookDetailFragment;
import fr.android.androidexercises.view.BookListFragment;
import fr.android.androidexercises.model.Book;


public class LibraryActivity extends AppCompatActivity implements BookListFragment.BookListListener {

    private Logger logger = new Logger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logger.info("Starting App !");

        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        logger.info("Is landscape : %s", isLandscape);


//        if (isLandscape){
//            setContentView(R.layout.vertical_activity_library);
//        } else {
            setContentView(R.layout.vertical_activity_library);
//        }

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();


        FragmentTransaction bookListFragment = transaction
                .replace(R.id.bookListFrame, new BookListFragment(), "BookListFragment");

//        if (isLandscape){
//            bookListFragment = transaction
//                    .replace(R.id.bookDetailFrame, new BookListFragment(), "BookListFragment");
//        }

        bookListFragment
                .commit();
    }


    @Override
    public void onClickOnListItem(Book book) {
        logger.info("onClickOnListItem(%s)", book);

        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putParcelable("book", book);

        BookDetailFragment fragment = new BookDetailFragment();

        fragment.setArguments(bundle);

        transaction
                .replace(R.id.bookListFrame, fragment, "BookDetailFragment")
                .addToBackStack(null)
                .commit();



    }
}
