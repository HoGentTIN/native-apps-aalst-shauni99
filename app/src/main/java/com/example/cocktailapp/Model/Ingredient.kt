package com.example.cocktailapp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ingredient_table")
data class Ingredient(
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "measure")
    val measure: String?)