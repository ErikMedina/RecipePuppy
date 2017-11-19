package com.erikmedina.recipepuppy.model.recipe

/**
 * Recipe model
 */
class Recipe: RecipeMapper {

    var title: String? = null
    var href: String? = null
    var ingredients: String? = null
    var thumbnailUrl: String? = null

    override fun setTitleMapper(title: String?) {
        this.title = title
    }

    override fun setIngredientsMapper(ingredients: String?) {
        this.ingredients = ingredients
    }

    override fun setHrefMapper(href: String?) {
        this.href = href
    }

    override fun setThumbnailUrlMapper(thumbnailUrl: String?) {
        this.thumbnailUrl = thumbnailUrl
    }
}
