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
    private boolean isLandscape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logger.info("Starting App !");

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        logger.info("Is landscape : %s", isLandscape);


        if (isLandscape){
            setUpLandscapeMode();
            return;
        }

        setUpProtraitMode();

    }

    private void setUpProtraitMode(){
        setContentView(R.layout.vertical_activity_library);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bookListFrame, new BookListFragment(), "BookListFragment")
                .commit();
    }

    private void setUpLandscapeMode(){
        setContentView(R.layout.horizontal_activity_library);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.bookListFrame, new BookListFragment(), "BookListFragment")
                .replace(R.id.bookDetailFrame, new BookDetailFragment(), "BookDetailFragment")
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

        int frameId = isLandscape ? R.id.bookDetailFrame : R.id.bookListFrame;

        transaction
                .replace(frameId, fragment, "BookDetailFragment")
                .addToBackStack(null)
                .commit();



    }
}
