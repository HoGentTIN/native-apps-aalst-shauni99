package com.example.cocktailapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cocktail: Cocktail)

    @Query("DELETE FROM cocktail_table")
    suspend fun nukeTable()

    @Query("SELECT * FROM cocktail_table WHERE favorite")
    suspend fun getFavoriteCocktails() : List<Cocktail>

    @Query("UPDATE cocktail_table SET favorite = 1 where idDrink = :idDrink")
    fun addToFavs(idDrink: String)

    @Query("UPDATE cocktail_table SET favorite = 0 where idDrink = :idDrink")
    fun removeFromFavs(idDrink: String)


}
