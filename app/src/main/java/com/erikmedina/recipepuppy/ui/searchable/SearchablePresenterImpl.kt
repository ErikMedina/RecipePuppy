package com.erikmedina.recipepuppy.ui.searchable

import android.util.Log
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractor
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractorImpl
import com.erikmedina.recipepuppy.model.recipesinfo.RecipesInfo
import okhttp3.ResponseBody

class SearchablePresenterImpl(view: SearchableView) : SearchablePresenter {

    private val mView = view
    private var getRecipesInfoInteractor: GetRecipesInfoInteractor = GetRecipesInfoInteractorImpl()

    override fun searchRecipes(query: String) {
        getRecipesInfoInteractor.execute("", query,1, object : GetRecipesInfoInteractor.OnGetRecipesInfoListener {
            override fun onGetRecipesInfoSuccess(recipesInfo: RecipesInfo) {
                Log.d(TAG, "[onGetRecipesInfoSuccess] recipesInfoDto received")
                mView.setRecipes(recipesInfo.recipes)
            }

            override fun onGetRecipesInfoError(error: ResponseBody) {
                Log.d(TAG, "[onGetRecipesInfoError] $error")
            }
        })
    }

    companion object {
        private const val TAG = "SearchablePresenterImpl"
    }
}
