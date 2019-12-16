package com.example.cocktailapp.model.repository

import android.content.Context
import android.util.Log
import com.example.cocktailapp.App
import com.example.cocktailapp.database.CocktailDatabase
import com.example.cocktailapp.database.CocktailDatabaseDao
import com.example.cocktailapp.model.Cocktail
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

    override suspend fun insert(cocktail: Cocktail) {
        cocktailDao.insert(cocktail)
    }

    override suspend fun getByName(strDrink: String): Cocktail {
        return cocktailDao.getCocktailByName(strDrink)
    }

    override suspend fun getCocktailById(idDrink: String): Cocktail? {
        return cocktailService.getCocktailById(idDrink)
    }

    override suspend fun ensureDelete() {
        cocktailDao.nukeTable()
    }

    override suspend fun getAllAlcoholicCocktails(alcoholic: String): List<Cocktail> {
        return cocktailDao.getCocktailsAlcoholic(alcoholic)
    }

    // ophalen cocktails uit api
    override suspend fun loadAllAlcoholicCocktailsFromApi(): List<Cocktail> {
        try {
            return cocktailService.getAlcoholicCocktails().drinks!!
        } catch (e: Exception) {
            Log.e("Error", e.message)
        }
        return listOf()
    }

    // toevoegen cocktails aan Dao
    override suspend fun addCocktailsToDatabase(cocktails: List<Cocktail>) {
        cocktails.forEach {

                cocktailDao.insert(it)
        }
    }
}
