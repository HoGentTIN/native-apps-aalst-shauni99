package com.example.cocktailapp.fragment.info

import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App
import kotlinx.android.synthetic.main.fragment_info.*

class InfoViewModel : ViewModel() {

    init {
        App.appComponent.inject(this)
    }
}
