package com.example.cocktailapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailapp.Model.Ingredient

@Dao
interface IngredientDatabaseDao {

    @Query("SELECT * FROM ingredient_table WHERE idIngredient = :id")
    suspend fun getIngredientById(id: String?): MutableList<Ingredient>


    @Insert
    suspend fun insert(ingredient: Ingredient)
}