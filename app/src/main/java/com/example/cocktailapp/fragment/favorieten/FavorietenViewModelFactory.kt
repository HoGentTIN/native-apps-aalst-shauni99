package com.example.cocktailapp.fragment.favorieten

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FavorietenViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavorietenViewModel::class.java)) {
            return FavorietenViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}