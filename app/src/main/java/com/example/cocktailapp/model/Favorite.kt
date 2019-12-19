package com.example.cocktailapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class Favorite (
    @PrimaryKey(autoGenerate = true)
    var favId: Int?,
    var drinkId: String? = "",
    var drinkName: String? = "",
    var drinkPhoto: String? = ""
)
