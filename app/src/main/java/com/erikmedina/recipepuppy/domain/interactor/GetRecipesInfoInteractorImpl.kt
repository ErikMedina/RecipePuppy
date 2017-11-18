package com.erikmedina.recipepuppy.domain.interactor

import android.util.Log
import com.erikmedina.recipepuppy.domain.entity.RecipesInfo
import com.erikmedina.recipepuppy.domain.service.MyApiEndpointInterface
import com.erikmedina.recipepuppy.domain.service.ServiceManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Interactor to requests recipes info
 */
class GetRecipesInfoInteractorImpl : GetRecipesInfoInteractor {

    private val myApiEndpointInterface: MyApiEndpointInterface = ServiceManager.createWebService()

    override fun execute(ingredients: String, query: String, page: Int,
                         listener: GetRecipesInfoInteractor.OnGetRecipesInfoListener) {
        val call = myApiEndpointInterface.getRecipesInfo("", query, page)
        call.enqueue(object : Callback<RecipesInfo> {
            override fun onFailure(call: Call<RecipesInfo>?, t: Throwable?) {
                Log.e(TAG, t.toString())
            }

            override fun onResponse(call: Call<RecipesInfo>?, response: Response<RecipesInfo>?) {
                Log.i(TAG, "[onResponse] recipes info response received successfully")
                listener.onGetLocationsInfoSuccess(response)
            }
        })
    }

    companion object {
        const val TAG = "GetRecipesInfoInteractorImpl"
    }
}