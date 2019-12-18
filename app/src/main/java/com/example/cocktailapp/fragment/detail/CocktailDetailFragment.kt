package com.example.cocktailapp.fragment.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.adapter.CocktailAdapter


import com.example.cocktailapp.databinding.FragmentCocktailDetailBinding
import com.google.android.material.appbar.AppBarLayout

import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 */
class CocktailDetailFragment : Fragment() {
    private val viewModel: CocktailDetailViewModel by lazy {
        ViewModelProviders.of(this).get(CocktailDetailViewModel::class.java)
    }

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

        binding.viewModel = viewModel


        val collapsingToolbarLayout =
            binding.collapsingToolbar as CollapsingToolbarLayout
        val appBarLayout = binding.appBar as AppBarLayout
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = true
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = viewModel.cocktail.strDrink
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = " "
                    //careful there should a space between double quote otherwise it wont work
                    isShow = false
                }
            }
        })
        

        return binding.root

    }
}



