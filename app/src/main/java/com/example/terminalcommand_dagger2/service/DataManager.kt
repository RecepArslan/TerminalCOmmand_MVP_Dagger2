package com.example.terminalcommand_dagger2.service

import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.models.CommandModel

interface DataManager {
    fun getCategories(serviceCallback: ServiceCallback<List<CategoriesModel>>)
    fun getCommandsOfCategory(categoryId: String, serviceCallback: ServiceCallback<List<CommandModel>>)
}