package com.example.cocktailapp.fragment.favorieten

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocktailapp.App
import com.example.cocktailapp.R
import com.example.cocktailapp.database.CocktailDatabaseDao
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.Favorite
import com.revosleap.simpleadapter.SimpleAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavorietenViewModel : ViewModel() {


    init {
        App.appComponent.inject(this)

    }






}