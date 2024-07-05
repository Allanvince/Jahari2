package com.vince.jahariafrica.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.vince.jahariafrica.R
import com.vince.jahariafrica.databinding.FragmentHomeBinding
import com.vince.jahariafrica.viewModels.HomeViewModel

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    companion object {
        fun newInstance() = Home()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val menuIcon = binding.menuIcon
        menuIcon.setOnClickListener {
            val menuFragment = Menu()
            val transition: FragmentTransaction = requireFragmentManager().beginTransaction()
            transition.replace(R.id.flFragment, menuFragment)
            transition.commit()
        }

        return binding.root
    }
}