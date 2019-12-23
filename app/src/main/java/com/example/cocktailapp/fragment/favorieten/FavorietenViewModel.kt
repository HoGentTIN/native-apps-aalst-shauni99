package com.example.cocktailapp.fragment.favorieten

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.App
import com.example.cocktailapp.database.CocktailDatabaseDao
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.repository.ICocktailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavorietenViewModel : ViewModel() {

    @Inject
    lateinit var cocktailRepository: ICocktailRepository

    init {
        App.appComponent.inject(this)
        getFavoriteCocktails()
    }

    private val _favoriteCocktails = MutableLiveData<List<Cocktail>>()
    val favoriteCocktails: LiveData<List<Cocktail>>
        get()= _favoriteCocktails

    private val _navigateToSelectedCocktail = MutableLiveData<Cocktail>()
    val navigateToSelectedCocktail: LiveData<Cocktail>
        get() = _navigateToSelectedCocktail


    private fun getFavoriteCocktails(){
        viewModelScope.launch {
            var cocktails= cocktailRepository.getFavoriteCocktails()
            _favoriteCocktails.value = cocktails
            Log.d("favorieten", cocktails.size.toString())
        }
    }

    fun displayCocktailDetails(cocktail: Cocktail) {
        _navigateToSelectedCocktail.value = cocktail
    }

    fun displayCocktailDetailsComplete(cocktail: Cocktail) {
        _navigateToSelectedCocktail.value = null
    }

}
