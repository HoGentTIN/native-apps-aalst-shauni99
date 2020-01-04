package com.example.cocktailapp.database


import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cocktailapp.model.Cocktail

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
class CocktailDatabaseTest {

    private lateinit var cocktailDao: CocktailDatabaseDao
    private lateinit var cocktailtest: Cocktail
    private lateinit var cocktailtest2: Cocktail
    private lateinit var cocktailtest3: Cocktail
    private lateinit var db: CocktailDatabase

    @Before
    fun createDb() {
     val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, CocktailDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        cocktailDao = db.cocktailDao

        cocktailtest = Cocktail("2", "thumb","naam","instructions","Alcoholic","category","glass",
            false, "ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient"
        ,"ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","measure", "measure", "measure",
            "measure", "measure", "measure","measure", "measure", "measure","measure", "measure", "measure",
            "measure", "measure", "measure")


        cocktailtest2 = Cocktail("3", "thumb","naam2","instructions","Alcoholic","category","glass",
            false, "ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient"
            ,"ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","measure", "measure", "measure",
            "measure", "measure", "measure","measure", "measure", "measure","measure", "measure", "measure",
            "measure", "measure", "measure")

        cocktailtest3 = Cocktail("4", "thumb","naam3","instructions","Alcoholic","category","glass",
            true, "ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient"
            ,"ingredient", "ingredient", "ingredient","ingredient", "ingredient", "ingredient","measure", "measure", "measure",
            "measure", "measure", "measure","measure", "measure", "measure","measure", "measure", "measure",
            "measure", "measure", "measure")
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertCocktailGetCocktail() {
        runBlocking {
          cocktailDao.insert(cocktailtest)
        val cocktail = cocktailDao.getCocktailById(cocktailtest.idDrink)
        assertEquals(cocktail.strDrink, cocktailtest.strDrink)}
        }

    @Test
    fun insertCocktailCount(){
        runBlocking {
            cocktailDao.insert(cocktailtest)
            cocktailDao.insert(cocktailtest2)
            assertEquals(cocktailDao.getCocktailsAlcoholic("Alcoholic").count(), 2)

        }

    }

    @Test
    fun insertDuplicateCocktailNoError(){
        runBlocking {
            cocktailDao.insert(cocktailtest)
            cocktailDao.insert(cocktailtest)
            assertEquals(cocktailDao.getCocktailsAlcoholic("Alcoholic").count(), 1)

        }
    }

    @Test
    fun insertFavoriteCountFavorites(){
        runBlocking {
            cocktailDao.insert(cocktailtest)
            cocktailDao.insert(cocktailtest2)
            cocktailDao.insert(cocktailtest3)
            assertEquals(cocktailDao.getFavoriteCocktails().count(), 1)

        }
    }
    }

