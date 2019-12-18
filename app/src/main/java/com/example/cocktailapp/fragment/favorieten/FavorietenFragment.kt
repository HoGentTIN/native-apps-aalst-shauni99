package com.example.cocktailapp.fragment.favorieten

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.FragmentFavorietenBinding

/**
 * A simple [Fragment] subclass.
 */
class FavorietenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("My favourites")
        // Inflate the layout for this fragment
        val binding: FragmentFavorietenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorieten, container, false)

        return binding.root
    }
}
