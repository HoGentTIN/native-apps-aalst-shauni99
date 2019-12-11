package com.example.cocktailapp.Model.Repository

import android.content.Context
import android.util.Log
import com.example.cocktailapp.Database.CocktailDatabase
import com.example.cocktailapp.Database.CocktailDatabaseDao
import com.example.cocktailapp.Model.Cocktail
import com.example.cocktailapp.App
import com.example.cocktailapp.Network.CocktailService
import javax.inject.Inject

class CocktailRepository(context: Context) : ICocktailRepository {

    @Inject
    lateinit var cocktailService: CocktailService

    init {
        // Inject Services with Dagger
        App.appComponent.inject(this)
    }

    private val cocktailDatabase = CocktailDatabase.getInstance(context)
    private val cocktailDao: CocktailDatabaseDao = cocktailDatabase.cocktailDao

    init {
        App.appComponent.inject(this)
    }


    override suspend fun insert(cocktail: Cocktail) {
        cocktailDao.insert(cocktail)
    }

    override suspend fun getByName(strDrink: String): Cocktail {
        return cocktailDao.getCocktailByName(strDrink)
    }

    override suspend fun getById(idDrink: String): Cocktail? {
        return cocktailDao.getCocktailById(idDrink)
    }

    override suspend fun ensureDelete() {
        cocktailDao.nukeTable()
    }


    override suspend fun getAllAlcoholicCocktails(alcoholic: String): List<Cocktail> {
        return cocktailDao.getCocktailsAlcoholic(alcoholic)
    }





    //ophalen cocktails uit api
    override suspend fun loadAllAlcoholicCocktailsFromApi() {
        try {
            addCocktailsToDatabase(cocktailService.getAlcoholicCocktails())
        }catch (e: Exception){
            Log.e("Error", e.message)
        }

    }

    // toevoegen cocktails aan Dao
    override suspend fun addCocktailsToDatabase(cocktails: List<Cocktail>) {
        cocktails.forEach {

                cocktailDao.insert(it)


        }
    }


}