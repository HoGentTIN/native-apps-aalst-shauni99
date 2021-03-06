package com.example.cocktailapp.model.repository

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.cocktailapp.App
import com.example.cocktailapp.Network.CocktailService
import com.example.cocktailapp.database.CocktailDatabase
import com.example.cocktailapp.database.CocktailDatabaseDao
import com.example.cocktailapp.model.Cocktail
import javax.inject.Inject

class CocktailRepository(context: Context) : ICocktailRepository {

    @Inject
    lateinit var cocktailService: CocktailService

    var connectivityManager = provideConnectivityManager(context)

    var alcoholic = "Alcoholic"

    init {
        // Inject Services with Dagger
        App.appComponent.inject(this)
    }

    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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
        return cocktailService.getCocktailById(idDrink).drinks?.first()
    }

    override suspend fun ensureDelete() {
        cocktailDao.nukeTable()
    }

    override suspend fun getFavoriteCocktails(): List<Cocktail> {
        return cocktailDao.getFavoriteCocktails()
    }

    override suspend fun getAllAlcoholicCocktails(alcoholic: String): List<Cocktail> {
        if (connectedToInternet()) {
            val cocktail = cocktailService.getAlcoholicCocktails()
            var cocktails = mutableListOf<Cocktail>()
            cocktail.drinks!!.forEach { cocktail ->
                var cocktailToAdd: Cocktail =
                    cocktailService.getCocktailById(cocktail.idDrink).drinks!![0]
                cocktails.add(cocktailToAdd)
            }
            addCocktailsToDatabase(cocktails)
            return cocktailDao.getCocktailsAlcoholic(alcoholic)
        }
        return cocktailDao.getCocktailsAlcoholic(alcoholic)
    }

    // ophalen cocktails uit api
    override suspend fun loadAllAlcoholicCocktailsFromApi(): List<Cocktail> {
        try {
            return cocktailService.getAlcoholicCocktails().drinks!!
        } catch (e: Exception) {
        }
        return listOf()
    }

    // toevoegen cocktails aan Dao
    override suspend fun addCocktailsToDatabase(cocktails: List<Cocktail>) {

            cocktails.forEach {

                cocktailDao.insert(it)
        }
    }

    private fun connectedToInternet(): Boolean {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
