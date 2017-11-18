package com.erikmedina.recipepuppy.domain.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Class RecipesInfo wich contains recipes result
 */
class RecipesInfo {

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
    var results: List<Result>? = null

}