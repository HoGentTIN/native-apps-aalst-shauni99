package com.example.cocktailapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient_table")
data class Ingredient(

    @PrimaryKey(autoGenerate = false)
    var idIngredient: String = "",
    @ColumnInfo(name = "nameIngredient")
    val name: String?,
    @ColumnInfo(name = "measure")
    val measure: String?
)
