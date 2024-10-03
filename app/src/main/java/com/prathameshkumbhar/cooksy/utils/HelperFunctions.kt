package com.prathameshkumbhar.cooksy.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.Window
import androidx.core.content.ContextCompat

@SuppressLint("ObsoleteSdkInt")
fun changeStatusBarColor(window: Window, context: Context, colorRes: Int) {
    val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(colorRes)
    } else {
        ContextCompat.getColor(context, colorRes)
    }

    // Change status bar color
    window.statusBarColor = color
}