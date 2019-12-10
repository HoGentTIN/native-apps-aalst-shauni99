package com.example.cocktailapp.fragment.fragment.Search


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.FragmentFavorietenBinding
import com.example.cocktailapp.databinding.FragmentSearchBinding

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSearchBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_search, container, false)

        return binding.root
    }


}
