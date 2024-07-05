package com.vince.jahariafrica.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vince.jahariafrica.MainActivity
import com.vince.jahariafrica.R
import com.vince.jahariafrica.databinding.ActivityLoginBinding

class Login : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUpText = binding.signupText
        signUpText.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }
        val loginButton = binding.loginButton
        loginButton.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}