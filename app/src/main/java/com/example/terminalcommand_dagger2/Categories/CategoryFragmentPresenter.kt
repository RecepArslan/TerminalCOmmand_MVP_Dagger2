package com.example.terminalcommand_dagger2.Categories

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.terminalcommand_dagger2.MainActivity
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.command.CommandListFragment
import com.example.terminalcommand_dagger2.hideLoading
import com.example.terminalcommand_dagger2.key
import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.service.DataManager
import com.example.terminalcommand_dagger2.service.ServiceCallback
import javax.inject.Inject

class CategoryFragmentPresenter
@Inject
constructor(dataManager: DataManager) :
    CategoryFragmentMvpPresenter {
    var categoryList: List<CategoriesModel> = ArrayList<CategoriesModel>()
    lateinit var myView: CategoryFragmentMvpView
    lateinit var root: View
    var dataManager: DataManager
        @Inject set

    init {
        this.dataManager = dataManager
    }

    @Inject
    lateinit var fragment: CommandListFragment
    override fun getCategories(

    ) {

        myView.showLoading()
        dataManager.getCategories(object : ServiceCallback<List<CategoriesModel>> {

            override fun onSuccess(response: List<CategoriesModel>?) {

                categoryList = response!!
                myView.LoadDataCategoryList(categoryList, root)
                myView.hideLoading()
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                Toast.makeText(MainActivity().applicationContext, "hata", Toast.LENGTH_SHORT).show()
            }


        })


    }

    override fun setView(root: View, categoriesFragment: CategoriesFragment) {
        this.myView = categoriesFragment
        this.root = root
    }

    override fun setCommandListFragment(
        position: Int,
        requireContext: Context
    ) {
        sendData(position, fragment)


      MainActivity().createFragment(R.id.activity_mainActivity_frameLayout, fragment,requireContext)
    }

    fun sendData(position: Int, fragment: Fragment) {
        val args = Bundle()
        args.putString(key, categoryList.get(position).id)
        fragment.arguments = args
    }


}