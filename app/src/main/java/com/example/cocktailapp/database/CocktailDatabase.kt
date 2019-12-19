package com.example.cocktailapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.Favorite

@Database(entities = [Cocktail::class,Favorite::class], version = 3, exportSchema = false)
abstract class CocktailDatabase : RoomDatabase() {
    abstract val cocktailDao: CocktailDatabaseDao


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
