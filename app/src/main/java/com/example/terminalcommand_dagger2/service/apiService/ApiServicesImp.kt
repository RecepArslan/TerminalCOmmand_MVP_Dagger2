package com.example.terminalcommand_dagger2.service.apiService

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.service.CategoryServices
import com.example.terminalcommand_dagger2.service.ServiceCallback
import javax.inject.Inject


class ApiServicesImp :
    ApiServices {

    lateinit var categoryServices: CategoryServices


    @Inject
    constructor(categoryServices: CategoryServices) {
        this.categoryServices = categoryServices

    }

    override fun getCommandsOfCategory(
        categoryId: String,
        serviceCallback: ServiceCallback<List<CommandModel>>
    ) {
       categoryServices.getCommandsOfCategory(categoryId,serviceCallback)
    }

    override fun getCategories(serviceCallback: ServiceCallback<List<CategoriesModel>>) {
        categoryServices.getCategories(serviceCallback)
    }
}