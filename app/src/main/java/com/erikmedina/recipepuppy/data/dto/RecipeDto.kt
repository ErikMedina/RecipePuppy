package com.erikmedina.recipepuppy.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Class result which is a recipe
 */
class RecipeDto {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("href")
    @Expose
    var href: String? = null
    @SerializedName("ingredients")
    @Expose
    var ingredients: String? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnailUrl: String? = null

}
