package com.example.cocktailapp.fragment.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cocktailapp.model.Cocktail

class CocktailDetailViewModelFactory( private val cocktail: Cocktail, private val application: Application)
    : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CocktailDetailViewModel::class.java)) {
                return CocktailDetailViewModel(cocktail, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}
