package com.erikmedina.recipepuppy.ui.searchable

import android.util.Log
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractor
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractorImpl
import com.erikmedina.recipepuppy.model.recipesinfo.RecipesInfo

class SearchablePresenterImpl(view: SearchableView) : SearchablePresenter {

    private val mView = view
    private var getRecipesInfoInteractor: GetRecipesInfoInteractor = GetRecipesInfoInteractorImpl()

    override fun searchRecipes(query: String) {
        mView.showProgress()
        getRecipesInfoInteractor.execute(NOT_SPECIFIED, query, FIRST_PAGE, object : GetRecipesInfoInteractor.OnGetRecipesInfoListener {
            override fun onSuccess(recipesInfo: RecipesInfo) {
                Log.d(TAG, "[onSuccess] recipesInfoDto received")
                mView.hideProgress()
                mView.setRecipes(recipesInfo.recipes)
            }

            override fun onError(error: String?) {
                mView.hideProgress()
                mView.showError(error)
            }
        })
    }

    companion object {
        private const val TAG = "SearchablePresenterImpl"
        private const val NOT_SPECIFIED = ""
        private const val FIRST_PAGE = 1
    }
}
