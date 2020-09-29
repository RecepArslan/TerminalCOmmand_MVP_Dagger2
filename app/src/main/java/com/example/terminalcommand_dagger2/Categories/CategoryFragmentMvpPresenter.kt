package com.example.terminalcommand_dagger2.Categories

import android.content.Context
import android.view.View

interface CategoryFragmentMvpPresenter {
    fun getCategories()
    fun setView(root: View, categoriesFragment: CategoriesFragment)
    fun setCommandListFragment(position: Int, requireContext: Context)


}