package com.erikmedina.recipepuppy.domain.interactor

import com.erikmedina.recipepuppy.model.recipesinfo.RecipesInfo
import okhttp3.ResponseBody

interface GetRecipesInfoInteractor {

    interface OnGetRecipesInfoListener {

        fun onGetRecipesInfoSuccess(recipesInfo: RecipesInfo)

        fun onGetRecipesInfoError(error: ResponseBody)
    }

    fun execute(ingredients: String, query: String, page: Int, listener: OnGetRecipesInfoListener)
}
