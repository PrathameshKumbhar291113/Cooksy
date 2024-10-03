package com.prathameshkumbhar.cooksy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prathameshkumbhar.cooksy.databinding.ActivitySplashBinding
import com.prathameshkumbhar.cooksy.utils.changeStatusBarColor

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        changeStatusBarColor(window, this, R.color.olive_green)
        setContentView(binding.root)
    }

}