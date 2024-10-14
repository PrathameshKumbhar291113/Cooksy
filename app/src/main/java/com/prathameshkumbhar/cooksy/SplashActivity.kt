package com.prathameshkumbhar.cooksy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.prathameshkumbhar.cooksy.databinding.ActivitySplashBinding
import com.prathameshkumbhar.cooksy.feature.auth.AuthActivity
import com.prathameshkumbhar.cooksy.utils.changeStatusBarColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import splitties.activities.start

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        changeStatusBarColor(window, this, R.color.olive_green)
        setContentView(binding.root)

        navigateToAuthActivity()

    }

    private fun navigateToAuthActivity() {
        lifecycleScope.launch {
            delay(3000)
            start<AuthActivity>()
            finish()
        }

    }

}










