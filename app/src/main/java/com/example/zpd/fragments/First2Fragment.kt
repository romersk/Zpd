package com.example.zpd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.zpd.R
import com.example.zpd.databinding.FragmentFirst2Binding

class First2Fragment : Fragment() {
    private var binding: FragmentFirst2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirst2Binding.inflate(inflater, container, false)
        return binding!!.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonFirst?.setOnClickListener { v ->
            NavHostFragment.findNavController(this@First2Fragment)
                .navigate(R.id.action_First2Fragment_to_Second2Fragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}