package com.bosleo.studentapp.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.beVisibleIf(beVisible: Boolean) = if (beVisible) beVisible() else beGone()
fun View.beInvisible() {
    visibility = View.INVISIBLE
}

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun View.beGone() {
    visibility = View.GONE
}

fun Context.showToast(message: String)
{
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}