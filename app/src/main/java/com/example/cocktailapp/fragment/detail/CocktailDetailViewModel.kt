package com.example.cocktailapp.fragment.detail

import android.app.Application
import android.util.Log
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



    private val _selectedCocktail = MutableLiveData<Cocktail>()

    fun loadCocktailById(){
        viewModelScope.launch {
            var cocktails = cocktailRepository.getCocktailById(cocktail.idDrink)
            _selectedCocktail.value = cocktails
        }
    }

    private var _favorieteCocktails = MutableLiveData<List<Cocktail>>()
    val favorieteCocktails: LiveData<List<Cocktail>>
        get() = _favorieteCocktails


    private var _refresh = MutableLiveData<Int>()
    val refresh: LiveData<Int>
        get() = _refresh

    private val _cocktails= MutableLiveData<List<Cocktail>>()
    val cocktails: LiveData<List<Cocktail>>
        get() = _cocktails


    val selectedCocktail: MutableLiveData<Cocktail>
        get() = _selectedCocktail

    init {
        App.appComponent.inject(this)
        _selectedCocktail.value = cocktail
        loadCocktailById()
        _favorieteCocktails.value = arrayListOf()
        if(favorieteCocktails != null){
            _favorieteCocktails.value
        }
    }

    fun onFavorieteCocktailClicked(idDrink: String){


        viewModelScope.launch {
            var cocktail = getCocktail(idDrink)
            if(cocktail != null){

                if(favorieteCocktails != null){


                    if(cocktail.favorieteCocktails.contains(cocktail!!)){
                        cocktail.removeFavoriet(cocktail!!)
                    } else{
                       cocktail.addFavoriet(cocktail!!)

                    }
                }else{

                    cocktail.favorieteCocktails = arrayListOf()
                    cocktail.addFavoriet(cocktail!!)

                }

            }

            _favorieteCocktails.value
            _refresh.value = refresh.value?.plus(1)
            _cocktails.value = ArrayList<Cocktail>()

        }
    }

    suspend fun getCocktail(idDrink: String): Cocktail?{
        return cocktailRepository.getCocktailById(idDrink)
    }



   }