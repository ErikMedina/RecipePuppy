package com.erikmedina.recipepuppy.model.recipesinfo

import com.erikmedina.recipepuppy.data.dto.RecipeDto

/**
 * Created by erik on 11/19/17.
 */
interface RecipesInfoMapper {

    fun setRecipesMapper(recipeDtos: List<RecipeDto>?)
}