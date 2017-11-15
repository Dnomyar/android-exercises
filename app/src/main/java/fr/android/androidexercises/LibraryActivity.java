package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //boolean isLandscape = getResources().getBoolean(R.bool.landscape);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, new BookListFragment(), "BookListFragment")
                .commit();
    }




}
