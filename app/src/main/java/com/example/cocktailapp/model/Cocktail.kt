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
    var strGlass: String? = "",

    var strIngredient1: String? = "",
    var strIngredient2: String? = "",
    var strIngredient3: String? = "",
    var strIngredient4: String? = "",
    var strIngredient5: String? = "",
    var strIngredient6: String? = "",
    var strIngredient7: String? = "",
    var strIngredient8: String? = "",
    var strIngredient9: String? = "",
    var strIngredient10: String? = "",
    var strIngredient11: String? = "",
    var strIngredient12: String? = "",
    var strIngredient13: String? = "",
    var strIngredient14: String? = "",
    var strIngredient15: String? = "",
    var strMeasure1: String? = "",
    var strMeasure2: String? = "",
    var strMeasure3: String? = "",
    var strMeasure4: String? = "",
    var strMeasure5: String? = "",
    var strMeasure6: String? = "",
    var strMeasure7: String? = "",
    var strMeasure8: String? = "",
    var strMeasure9: String? = "",
    var strMeasure10: String? = "",
    var strMeasure11: String? = "",
    var strMeasure12: String? = "",
    var strMeasure13: String? = "",
    var strMeasure14: String? = "",
    var strMeasure15: String? = "",
    var favorieteCocktails: MutableList<Cocktail> = arrayListOf()


) : Parcelable
{
    fun addFavoriet(cocktail:Cocktail){
        favorieteCocktails.add(cocktail)
    }

    fun removeFavoriet(cocktail:Cocktail){
        favorieteCocktails.remove(cocktail)
    }
}
