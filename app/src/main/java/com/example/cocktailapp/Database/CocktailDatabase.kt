package com.example.cocktailapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktailapp.Model.Cocktail
import com.example.cocktailapp.Model.Ingredient

@Database(entities = [Cocktail::class, Ingredient::class], version = 1, exportSchema = false)
abstract class CocktailDatabase : RoomDatabase() {
    abstract val cocktailDao: CocktailDatabaseDao
    abstract val ingredientDao: IngredientDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: CocktailDatabase? = null

        fun getInstance(context: Context): CocktailDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CocktailDatabase::class.java,
                        "cocktail_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}