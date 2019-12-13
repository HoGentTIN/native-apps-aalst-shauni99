package com.example.cocktailapp.fragment.info

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App

class InfoViewModel : ViewModel() {
    init {
        App.appComponent.inject(this)
    }
}
