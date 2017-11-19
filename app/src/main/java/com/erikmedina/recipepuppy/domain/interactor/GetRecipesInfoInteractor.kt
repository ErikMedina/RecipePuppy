package com.erikmedina.recipepuppy.domain.interactor

import com.erikmedina.recipepuppy.model.recipesinfo.RecipesInfo

interface GetRecipesInfoInteractor {

    interface OnGetRecipesInfoListener {

        fun onSuccess(recipesInfo: RecipesInfo)

        fun onError(error: String?)
    }

    fun execute(ingredients: String, query: String, page: Int, listener: OnGetRecipesInfoListener)
}
