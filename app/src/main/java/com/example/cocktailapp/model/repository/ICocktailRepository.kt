package com.example.cocktailapp.model.repository

import com.example.cocktailapp.model.Cocktail

interface ICocktailRepository {

    suspend fun loadAllAlcoholicCocktailsFromApi(): List<Cocktail>

    suspend fun getAllAlcoholicCocktails(alcoholic: String): List<Cocktail>

    suspend fun addCocktailsToDatabase(cocktails: List<Cocktail>)

    suspend fun getFavoriteCocktails() : List<Cocktail>

    suspend fun ensureDelete()

    suspend fun getCocktailById(idDrink: String): Cocktail?

    suspend fun getByName(strDrink: String): Cocktail?

    suspend fun insert(cocktail: Cocktail)
}
