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
        val itemView = holder?.itemView
        when (itemView){
            is BookItemView -> itemView.bind(this.books[position])
            else -> {}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
        ViewHolder(layoutInflater.inflate(ressource, parent, false))

    override fun getItemCount(): Int = books.size


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}

