package com.example.terminalcommand_dagger2.service

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel

interface CategoryServices {
    fun getCommandsOfCategory(categoryId:String, serviceCallback: ServiceCallback<List<CommandModel>>)
    fun getCategories(serviceCallback: ServiceCallback<List<CategoriesModel>>)
}