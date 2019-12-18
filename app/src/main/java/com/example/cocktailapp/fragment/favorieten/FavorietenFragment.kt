package com.example.cocktailapp.fragment.favorieten

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktailapp.R
import com.example.cocktailapp.adapter.FavoriteCocktailAdapter
import com.example.cocktailapp.databinding.FragmentFavorietenBinding

/**
 * A simple [Fragment] subclass.
 */
class FavorietenFragment : Fragment() {

    lateinit var viewModel: FavorietenViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentFavorietenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorieten, container, false)


        viewModel = ViewModelProviders.of(this, FavorietenViewModelFactory()).get(FavorietenViewModel::class.java)
        binding.favorietenViewModel = viewModel

        var adapter = FavoriteCocktailAdapter()
        binding.favList.adapter = adapter

        viewModel.favoriteCocktails.observe(viewLifecycleOwner, Observer {
            it?.let{

                adapter.submitList(it)
            }
        })


        return binding.root
    }
}
