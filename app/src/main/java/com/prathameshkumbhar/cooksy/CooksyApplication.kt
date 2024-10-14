package com.prathameshkumbhar.cooksy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CooksyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}