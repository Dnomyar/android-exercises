package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_view_item_book.view.*


/**
 * Created by damien on 10/11/2017.
 */
class BookItemView @JvmOverloads constructor(context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr), ItemView<Book> {

    override fun bind(element: Book): View {
        nameTextView.text = element.name
        priceTextView.text = element.price.toString()
        return this
    }
}