package com.example.cocktailapp.Network

import com.example.cocktailapp.Model.Cocktail
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CocktailService {


    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicCocktails(): List<Cocktail>

    @GET("filter.php?a=Non_Alcoholic")
    fun getNonAlcoholicCocktails(): List<Cocktail>

    @GET("lookup.php?i={idDrink}")
    fun getMovieById(@QueryMap hashMap: HashMap<String, String> = HashMap()): Cocktail
}