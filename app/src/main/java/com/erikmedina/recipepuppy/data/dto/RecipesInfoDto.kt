package com.erikmedina.recipepuppy.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * DTO for RecipesInfo
 */
class RecipesInfoDto {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("version")
    @Expose
    var version: Double? = null
    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("results")
    @Expose
    var recipeDtos: List<RecipeDto>? = null

}
