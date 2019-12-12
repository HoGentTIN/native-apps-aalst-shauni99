package com.example.cocktailapp.Fragment.Home

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App

class HomeViewModel : ViewModel() {
    init {
        App.appComponent.inject(this)
    }
}
