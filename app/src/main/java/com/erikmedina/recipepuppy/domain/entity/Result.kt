package com.erikmedina.recipepuppy.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Class result wich is a recipe
 */
class Result {

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
    var thumbnail: String? = null

}