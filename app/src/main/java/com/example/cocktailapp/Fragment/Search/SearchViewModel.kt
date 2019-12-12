package com.example.cocktailapp.Fragment.Search

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App

class SearchViewModel : ViewModel() {
    init {
        App.appComponent.inject(this)
    }
}
