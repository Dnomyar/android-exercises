package fr.android.androidexercises

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by damien on 10/11/2017.
 */
class RecyclerAdapter(val layoutInflater: LayoutInflater,
                      val books: List<Book>,
                      val ressource: Int): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        (holder!!.itemView as ItemView<Book>).bind(this.books.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(layoutInflater.inflate(ressource, parent!!, false))
    }

    override fun getItemCount(): Int {
        return books.size;
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}