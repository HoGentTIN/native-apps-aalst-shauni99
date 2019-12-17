package com.example.cocktailapp.fragment.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cocktailapp.App
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.repository.ICocktailRepository
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

class CocktailDetailViewModel(cocktail: Cocktail, app: Application) : AndroidViewModel(app) {
    @Inject
    lateinit var cocktailRepository: ICocktailRepository
    var cocktail = cocktail

    init {
        App.appComponent.inject(this)
        loadCocktailById()
    }

    private val _selectedCocktail = MutableLiveData<Cocktail>()

    fun loadCocktailById(){
        viewModelScope.launch {
            var cocktails = cocktailRepository.getCocktailById(cocktail.idDrink)
            _selectedCocktail.value = cocktails
        }
    }


    val selectedCocktail: LiveData<Cocktail>
        get() = _selectedCocktail


    init {
        _selectedCocktail.value = cocktail
    }

   }