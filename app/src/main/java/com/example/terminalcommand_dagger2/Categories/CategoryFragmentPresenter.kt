package com.example.terminalcommand_dagger2.Categories

import android.content.Context
import com.example.terminalcommand_dagger2.*
import com.example.terminalcommand_dagger2.base.BasePresenter
import com.example.terminalcommand_dagger2.command.CommandListFragment
import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.service.DataManager
import com.example.terminalcommand_dagger2.service.ServiceCallback
import javax.inject.Inject

class CategoryFragmentPresenter<V : CategoryFragmentMvpView>
@Inject
constructor(dataManager: DataManager) : BasePresenter<V>(dataManager),
    CategoryFragmentMvpPresenter<V> {
    var categoryList: List<CategoriesModel> = ArrayList()

    @Inject
    lateinit var fragment: CommandListFragment
    override fun getCategories() {
        mvpView.showLoading()

        dataManager.getCategories(object : ServiceCallback<List<CategoriesModel>> {

            override fun onSuccess(response: List<CategoriesModel>?) {
                categoryList = response!!
                mvpView.loadDataCategoryList(categoryList)
                mvpView.hideLoading()

            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.showText(errorMessage)
            }


        })


    }
    override fun setCommandListFragment(
        position: Int,
        requireContext: Context
    ) {
        //istediğim fragment'e istediğim String datayı gönderir
        sendStringData(key, categoryList.get(position).id, fragment)


        createFragment(R.id.activity_mainActivity_frameLayout, fragment, requireContext)

    }


}