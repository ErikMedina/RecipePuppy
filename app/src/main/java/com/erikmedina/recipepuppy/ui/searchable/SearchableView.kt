package com.erikmedina.recipepuppy.ui.searchable

import com.erikmedina.recipepuppy.model.recipe.Recipe

/**
 * Created by erik on 11/18/17.
 */
interface SearchableView {

    fun setRecipes(recipes: MutableList<Recipe>)
}
