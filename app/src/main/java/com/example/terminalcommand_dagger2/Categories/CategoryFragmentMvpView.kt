package com.example.terminalcommand_dagger2.Categories

import android.view.View
import com.example.terminalcommand_dagger2.models.CategoriesModel

interface CategoryFragmentMvpView {
    fun LoadDataCategoryList(
        categoryList: List<CategoriesModel>,
        root: View
    )

    fun showLoading()
    fun hideLoading()

}