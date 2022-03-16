package com.example.themovies.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.BindingAdapter

fun ProgressBar.show() {
    this.visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    this.visibility = View.GONE
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

@BindingAdapter("setState")
fun View.setState(state: DataState<Any>) {
    when (state) {
        is DataState.Loading -> {
            this.visibility = View.VISIBLE
        }
        is DataState.Success -> {
            this.visibility = View.GONE
        }
        is DataState.Error -> {
            this.visibility = View.GONE
        }
    }
}