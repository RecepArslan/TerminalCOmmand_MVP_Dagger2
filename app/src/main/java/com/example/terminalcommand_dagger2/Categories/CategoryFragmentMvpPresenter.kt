package com.example.terminalcommand_dagger2.Categories

import android.content.Context
import android.view.View
import com.example.terminalcommand_dagger2.base.MvpPresenter

interface CategoryFragmentMvpPresenter<V:CategoryFragmentMvpView>:MvpPresenter<V> {
    fun getCategories()
    fun setCommandListFragment(position: Int, requireContext: Context)


}