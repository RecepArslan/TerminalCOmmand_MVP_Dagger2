package com.example.terminalcommand_dagger2.service

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.service.apiService.ApiServices
import javax.inject.Inject

class DataManagerImp : DataManager {
    lateinit var apiServices: ApiServices

    @Inject
    constructor(apiServices: ApiServices) {
        this.apiServices = apiServices
    }


    override fun getCategories(serviceCallback: ServiceCallback<List<CategoriesModel>>) {
       apiServices!!.getCategories(serviceCallback)
    }

    override fun getCommandsOfCategory(
        categoryId: String,
        serviceCallback: ServiceCallback<List<CommandModel>>
    ) {
        apiServices.getCommandsOfCategory(categoryId,serviceCallback)
    }


}