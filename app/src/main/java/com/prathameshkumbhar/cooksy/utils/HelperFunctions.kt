package com.prathameshkumbhar.cooksy.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.core.content.ContextCompat

fun hideStatusBarFromActivity(window: Window){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.setDecorFitsSystemWindows(false)
        window.insetsController?.apply {
            hide(WindowInsets.Type.statusBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } else {
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }


}


@SuppressLint("ObsoleteSdkInt")
fun changeStatusBarColor(window: Window, context: Context, colorRes: Int) {
    val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getColor(colorRes)
    } else {
        ContextCompat.getColor(context, colorRes)
    }

    window.statusBarColor = color
}