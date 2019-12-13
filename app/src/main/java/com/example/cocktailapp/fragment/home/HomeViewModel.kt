package com.example.cocktailapp.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.App
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.repository.ICocktailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    @Inject
    lateinit var cocktailRepository: ICocktailRepository

    init {
        App.appComponent.inject(this)
        loadCocktails()
    }

    private val _alcoholicCocktails = MutableLiveData<List<Cocktail>>()
    val alcoholicCocktails: LiveData<List<Cocktail>>
    get() = _alcoholicCocktails

    private val _nonAlcoholicCocktails = MutableLiveData<List<Cocktail>>()
    val nonAlcoholicCocktails: LiveData<List<Cocktail>>
        get() = _nonAlcoholicCocktails

    private val _navigateToSelectedCocktail = MutableLiveData<Cocktail>()
    val navigateToSelectedCocktail: LiveData<Cocktail>
        get() = _navigateToSelectedCocktail





    fun loadCocktails(){
        viewModelScope.launch {
            var cocktails = cocktailRepository.loadAllAlcoholicCocktailsFromApi()
            _alcoholicCocktails.value = cocktails
        }
    }

   fun displayCocktailDetails(cocktail:Cocktail){
       _navigateToSelectedCocktail.value = cocktail
   }


    fun displayCocktailDetailsComplete(cocktail:Cocktail){
        _navigateToSelectedCocktail.value = null
    }

}
