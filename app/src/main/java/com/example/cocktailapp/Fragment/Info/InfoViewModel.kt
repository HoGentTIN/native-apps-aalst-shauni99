package com.example.cocktailapp.Fragment.Info

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App

class InfoViewModel : ViewModel() {
    init {
        App.appComponent.inject(this)
    }
}
