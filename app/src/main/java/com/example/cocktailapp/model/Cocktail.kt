package com.example.cocktailapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cocktail_table")
data class Cocktail(

    @PrimaryKey(autoGenerate = false)
    var idDrink: String = "",
    @ColumnInfo(name = "thumb")
    var strDrinkThumb: String? = "",
    @ColumnInfo(name = "nameCocktail")
    var strDrink: String? = "",
    @ColumnInfo(name = "instructions")
    var strInstructions: String? = "",
    @ColumnInfo(name = "alcoholic")
    var strAlcoholic: String? = "",
    @ColumnInfo(name = "category")
    var strCategory: String? = "",
    @ColumnInfo(name = "glass")
    var strGlass: String? = ""
) : Parcelable
