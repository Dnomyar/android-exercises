package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.view.LayoutInflater
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_library.*
import java.util.*


class LibraryActivity : AppCompatActivity() {

    private val RANDOM = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)


        bookListView.layoutManager = GridLayoutManager(this, 1)
        bookListView.adapter = RecyclerAdapter(
                LayoutInflater.from(this),
                getBooks(),
                R.layout.custom_view_item_book
        )
    }


    private fun getBooks(): List<Book> =
        (0..99).map {
            Book(
                "Garry Potier Tome $it",
                RANDOM.nextFloat()
            )
        }

}
