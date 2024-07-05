package com.vince.jahariafrica

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.vince.jahariafrica.databinding.ActivityMainBinding
import com.vince.jahariafrica.fragments.Favorites
import com.vince.jahariafrica.fragments.Home
import com.vince.jahariafrica.fragments.Profile
import com.vince.jahariafrica.fragments.Shop

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val homeFragment = Home()
        val favoriteFragment = Favorites()
        val shopFragment = Shop()
        val profileFragment = Profile()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.favorite -> setCurrentFragment(favoriteFragment)
                R.id.shop -> setCurrentFragment(shopFragment)
                R.id.profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}