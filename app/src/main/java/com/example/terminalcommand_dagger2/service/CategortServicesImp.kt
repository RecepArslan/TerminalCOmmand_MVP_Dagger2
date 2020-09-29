package com.example.terminalcommand_dagger2.service

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.service.apiService.RestApi
import com.example.terminalcommand_dagger2.service.apiService.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class CategortServicesImp : CategoryServices {

    var apiServices: RestApi
    @Inject
    constructor(retrofitClient: RetrofitClient) {
       // this.retrofitClient=retrofitClient
        apiServices=retrofitClient.getClient().create(RestApi::class.java)
    }

    override fun getCommandsOfCategory(
        categoryId: String,
        serviceCallback: ServiceCallback<List<CommandModel>>
    ) {
        var call = apiServices.getCategoryInfo(categoryId.toString())

        call.enqueue(object : retrofit2.Callback<List<CommandModel>> {
            override fun onFailure(call: Call<List<CommandModel>>, t: Throwable) {
                serviceCallback.onError(500, t.message.toString())
            }

            override fun onResponse(call: Call<List<CommandModel>>, response: Response<List<CommandModel>>) {
                serviceCallback.onSuccess(response.body())
            }

        })




    }

    override fun getCategories(serviceCallback: ServiceCallback<List<CategoriesModel>>) {
        var call = apiServices.bring()

        call.enqueue(object : retrofit2.Callback<List<CategoriesModel>> {
            override fun onFailure(call: Call<List<CategoriesModel>>, t: Throwable) {
                serviceCallback.onError(500, t.message.toString())
            }

            override fun onResponse(
                call: Call<List<CategoriesModel>>,
                response: Response<List<CategoriesModel>>
            ) {
                serviceCallback.onSuccess(response.body())
            }


        })


    }


}