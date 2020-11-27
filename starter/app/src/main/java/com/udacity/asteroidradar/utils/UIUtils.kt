package com.udacity.asteroidradar.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.udacity.asteroidradar.R

fun displaySnackbar(snackbarText: String, view: View) {
    val snackbar = Snackbar.make(view, snackbarText, Snackbar.LENGTH_SHORT)
    val backgroundColor = ContextCompat.getColor(view.context, R.color.default_text_color)
    snackbar.view.setBackgroundColor(backgroundColor)
    snackbar.show()
}