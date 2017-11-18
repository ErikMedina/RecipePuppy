package com.erikmedina.recipepuppy.domain.service

import com.erikmedina.recipepuppy.domain.entity.RecipesInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Endpoints for requests
 */
interface MyApiEndpointInterface {

    @GET("./")
    fun getRecipesInfo(@Query("i") ingredient: String,
                       @Query("q") query: String,
                       @Query("p") page: Int): Call<RecipesInfo>
}