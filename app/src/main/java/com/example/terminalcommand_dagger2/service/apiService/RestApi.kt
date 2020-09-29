package com.example.terminalcommand_dagger2.service.apiService

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {
    @GET("/api/categories?language=TR")
    fun bring(): Call<List<CategoriesModel>>

    @GET("/api/categories/{categoryId}/commands")
    fun getCategoryInfo(@Path("categoryId") categoryId:String):Call<List<CommandModel>>
}