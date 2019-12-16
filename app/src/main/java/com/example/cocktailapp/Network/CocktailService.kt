package com.example.cocktailapp.Network

import com.example.cocktailapp.model.Cocktail
import com.example.cocktailapp.model.responses.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface CocktailService {

    @Headers("Content-Type: application/json")
    @GET("filter.php?a=Alcoholic")
   suspend fun getAlcoholicCocktails(): CocktailResponse

    @Headers("Content-Type: application/json")
    @GET("filter.php?a=Non_Alcoholic")
   suspend fun getNonAlcoholicCocktails(): CocktailResponse


    @Headers("Content-Type: application/json")
    @GET("lookup.php?")
    suspend fun getCocktailById(@Query("i") id:String): CocktailResponse
}

