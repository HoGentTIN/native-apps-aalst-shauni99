package com.example.cocktailapp.Network

import com.example.cocktailapp.model.responses.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CocktailService {

    @Headers("Content-Type: application/json")
    @GET("filter.php?a=Alcoholic")
    suspend fun getAlcoholicCocktails(): CocktailResponse

    @Headers("Content-Type: application/json")
    @GET("lookup.php?")
    suspend fun getCocktailById(@Query("i") id: String): CocktailResponse
}
