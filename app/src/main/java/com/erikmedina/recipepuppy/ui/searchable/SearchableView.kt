package com.erikmedina.recipepuppy.ui.searchable

import com.erikmedina.recipepuppy.model.recipe.Recipe
import com.erikmedina.recipepuppy.ui.base.PresenterView

/**
 * Created by erik on 11/18/17.
 */
interface SearchableView : PresenterView {

    fun setRecipes(recipes: MutableList<Recipe>)

    fun showProgress()

    fun hideProgress()
}
