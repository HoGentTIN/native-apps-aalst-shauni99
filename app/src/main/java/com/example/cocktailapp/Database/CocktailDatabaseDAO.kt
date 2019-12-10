package com.example.cocktailapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailapp.Model.Cocktail

@Dao
interface CocktailDatabaseDao {


    @Query("SELECT * FROM cocktail_table WHERE alcoholic = :alcoholic")
    suspend fun getCocktailsAlcoholic(alcoholic: String?): List<Cocktail>?

    @Query("SELECT * FROM cocktail_table WHERE name = :drinkName")
    suspend fun getCocktailByName(drinkName: String?): MutableList<Cocktail>

    @Query("SELECT * FROM cocktail_table WHERE idDrink = :id")
    suspend fun getCocktailById(id: String?): MutableList<Cocktail>

    @Insert
    suspend fun insert(cocktail: Cocktail)

}