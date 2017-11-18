package com.erikmedina.recipepuppy.ui.main

import android.util.Log
import com.erikmedina.recipepuppy.domain.entity.RecipesInfo
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractor
import com.erikmedina.recipepuppy.domain.interactor.GetRecipesInfoInteractorImpl
import retrofit2.Response

class MainPresenterImpl(private val view: MainView) : MainPresenter {

    private var getRecipesInfoInteractor: GetRecipesInfoInteractor = GetRecipesInfoInteractorImpl()

    override fun searchRecipes(query: String) {
        getRecipesInfoInteractor.execute("", "chicken",1, object : GetRecipesInfoInteractor.OnGetRecipesInfoListener {
            override fun onGetLocationsInfoSuccess(recipesInfo: Response<RecipesInfo>?) {
                Log.d(TAG, "[onGetLocationsInfoSuccess] recipesInfo received")
            }

            override fun onGetLocationsInfoError(error: String) {
                Log.d(TAG, "[onGetLocationsInfoError] $error")
            }

        })
    }

    companion object {
        private const val TAG = "MainPresenterImpl"
    }
}