package com.example.cocktailapp.fragment.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProviders

import com.example.cocktailapp.R
import com.example.cocktailapp.databinding.FragmentCocktailDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class CocktailDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentCocktailDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        val cocktail = CocktailDetailFragmentArgs.fromBundle(arguments!!).selectedCocktail
        val viewModelFactory = CocktailDetailViewModelFactory(cocktail, application)
        binding.viewModel = ViewModelProviders.of(
            this, viewModelFactory
        ).get(CocktailDetailViewModel::class.java)



  return binding.root
    }

}
