package com.udacity.asteroidradar.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun displaySnackbar(snackbarText: String, view: View) {
    Snackbar.make(view, snackbarText, Snackbar.LENGTH_SHORT).show()
}