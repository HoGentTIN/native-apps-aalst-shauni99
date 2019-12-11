package com.example.cocktailapp.Model.Repository

import com.example.cocktailapp.Model.Cocktail

interface ICocktailRepository {


    suspend fun loadAllAlcoholicCocktailsFromApi()

    suspend fun getAllAlcoholicCocktails(alcoholic: String): List<Cocktail>

    suspend fun addCocktailsToDatabase(cocktails: List<Cocktail>)

    suspend fun ensureDelete()

    suspend fun getById(idDrink: String): Cocktail?

    suspend fun getByName(strDrink: String): Cocktail?

    suspend fun insert(cocktail: Cocktail)
}