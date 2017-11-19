package com.erikmedina.recipepuppy.domain.interactor

import android.content.res.Resources
import android.util.Log
import com.erikmedina.recipepuppy.R
import com.erikmedina.recipepuppy.data.dto.RecipesInfoDto
import com.erikmedina.recipepuppy.domain.service.MyApiEndpointInterface
import com.erikmedina.recipepuppy.domain.service.ServiceManager
import com.erikmedina.recipepuppy.model.recipesinfo.RecipesInfo
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
        call.enqueue(object : Callback<RecipesInfoDto> {
            override fun onFailure(call: Call<RecipesInfoDto>?, t: Throwable?) {
                Log.d(TAG, "[onFailure] response was not successful: $t")
                listener.onGetRecipesInfoError("There is a problem, try later please")
            }

            override fun onResponse(call: Call<RecipesInfoDto>?, response: Response<RecipesInfoDto>) {
                Log.i(TAG, "[onResponse] recipes info received successfully")
                if (response.isSuccessful) {
                    val recipesInfo = RecipesInfo()
                    recipesInfo.setRecipesMapper(response.body().recipeDtos)
                    listener.onGetRecipesInfoSuccess(recipesInfo)
                } else{
                    Log.d(TAG, "[onResponse] response was not successful: ${response.errorBody()}")
                    listener.onGetRecipesInfoError(Resources.getSystem().getString(R.string.error_connection))
                }
            }
        })
    }

    companion object {
        const val TAG = "GetRecipesInfo"
    }
}