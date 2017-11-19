package com.erikmedina.recipepuppy.model.recipe

/**
 * Created by erik on 11/19/17.
 */
interface RecipeMapper {

    fun setTitleMapper(title: String?)

    fun setIngredientsMapper(ingredients: String?)

    fun setHrefMapper(href: String?)

    fun setThumbnailUrlMapper(thumbnailUrl: String?)

}
