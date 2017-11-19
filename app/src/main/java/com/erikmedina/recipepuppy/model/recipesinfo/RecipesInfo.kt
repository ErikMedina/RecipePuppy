package com.erikmedina.recipepuppy.model.recipesinfo

import com.erikmedina.recipepuppy.data.dto.RecipeDto
import com.erikmedina.recipepuppy.model.recipe.Recipe

/**
 * Created by erik on 11/19/17.
 */
class RecipesInfo: RecipesInfoMapper {

    lateinit var recipes: MutableList<Recipe>

    override fun setRecipesMapper(recipeDtos: List<RecipeDto>?) {
        recipes = mutableListOf()
        recipeDtos?.forEach {
            val recipe = Recipe()
            recipe.setTitleMapper(it.title)
            recipe.setIngredientsMapper(it.ingredients)
            recipe.setHrefMapper(it.href)
            recipe.setThumbnailUrlMapper(it.thumbnailUrl)
            recipes.add(recipe)
        }
    }
}
