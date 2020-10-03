package com.example.terminalcommand_dagger2.Categories

import android.view.View
import com.example.terminalcommand_dagger2.base.MvpView
import com.example.terminalcommand_dagger2.models.CategoriesModel

interface CategoryFragmentMvpView:MvpView {
    fun loadDataCategoryList(
        categoryList: List<CategoriesModel>)


}