package com.example.zpd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.zpd.R
import com.example.zpd.databinding.FragmentSecond2Binding

class Second2Fragment : Fragment() {
    private var binding: FragmentSecond2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecond2Binding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonSecond?.setOnClickListener { v ->
            NavHostFragment.findNavController(this@Second2Fragment)
                .navigate(R.id.action_Second2Fragment_to_First2Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}