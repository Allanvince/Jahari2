package com.vince.jahariafrica.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.vince.jahariafrica.R
import com.vince.jahariafrica.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide)

        lifecycleScope.launch {
            binding.logo.startAnimation(bounceAnimation)
            delay(1000)
            binding.appName.startAnimation(slideAnimation)
            delay(1000)

            startActivity(Intent(this@SplashScreen, Login::class.java))
            finish()
        }
    }
}