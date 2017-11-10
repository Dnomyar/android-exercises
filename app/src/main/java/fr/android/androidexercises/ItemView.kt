package fr.android.androidexercises

import android.view.View

/**
 * Created by damien on 10/11/2017.
 */
interface ItemView<T> {
    fun bind(element: T): View
}