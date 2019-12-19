package com.example.cocktailapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.Favorite
import kotlinx.android.synthetic.main.fragment_cocktail_detail.view.favorite

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



    @Query("SELECT * FROM favorites_table ORDER BY favId DESC")
    fun getFavs(): MutableList<Favorite>

    @Query("UPDATE cocktail_table SET favorite = 1 where idDrink = :idDrink")
    fun addToFavs(idDrink: String)

    @Query("UPDATE cocktail_table SET favorite = 0 where idDrink = :idDrink")
    fun removeFromFavs(idDrink: String)


    @Query("SELECT * FROM favorites_table WHERE favId = :favId" )
    fun isFavorite(favId: Int): Boolean



}