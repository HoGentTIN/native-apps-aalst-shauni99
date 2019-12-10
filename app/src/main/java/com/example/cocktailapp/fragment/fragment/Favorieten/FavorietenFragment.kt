package com.example.cocktailapp.fragment.fragment.Favorieten


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.FragmentFavorietenBinding

/**
 * A simple [Fragment] subclass.
 */
class FavorietenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFavorietenBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_favorieten, container, false)

        return binding.root
    }



}
