package com.example.cocktailapp.Model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail_table")
data class Cocktail(

    @ColumnInfo(name = "thumb")
    var strDrinkThumb: String? = "",
    @ColumnInfo(name = "name")
    var strDrink: String? = "",
    @ColumnInfo(name = "instructions")
    var strInstructions: String? = "",
    @ColumnInfo(name = "alcoholic")
    var strAlcoholic: String? = "",
    @ColumnInfo(name = "category")
    var strCategory: String? = "",
    @ColumnInfo(name = "glass")
    var strGlass: String? = "",

    @Embedded
val ingredient: Ingredient,
    @PrimaryKey(autoGenerate = false)
        var idDrink: String? = ""

)
