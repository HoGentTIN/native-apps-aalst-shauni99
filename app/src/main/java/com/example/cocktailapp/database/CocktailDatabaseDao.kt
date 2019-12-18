package com.example.cocktailapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailapp.model.Cocktail

@Dao
interface CocktailDatabaseDao {

    @Query("SELECT * FROM cocktail_table WHERE alcoholic = :alcoholic")
    suspend fun getCocktailsAlcoholic(alcoholic: String?): List<Cocktail>

    @Query("SELECT * FROM cocktail_table WHERE nameCocktail = :drinkName")
    suspend fun getCocktailByName(drinkName: String?): Cocktail

    @Query("SELECT * FROM cocktail_table WHERE idDrink = :id")
    suspend fun getCocktailById(id: String?): Cocktail

    @Insert
    suspend fun insert(cocktail: Cocktail)

    @Query("DELETE FROM cocktail_table")
    suspend fun nukeTable()
}
