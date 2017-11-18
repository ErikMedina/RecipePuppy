package com.erikmedina.recipepuppy.domain.interactor

import com.erikmedina.recipepuppy.domain.entity.RecipesInfo
import retrofit2.Response

interface GetRecipesInfoInteractor {

    interface OnGetRecipesInfoListener {

        fun onGetLocationsInfoSuccess(recipesInfo: Response<RecipesInfo>?)

        fun onGetLocationsInfoError(error: String)
    }

    fun execute(ingredients: String, query: String, page: Int, listener: OnGetRecipesInfoListener)
}
