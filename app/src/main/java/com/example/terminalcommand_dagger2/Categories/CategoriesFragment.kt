package com.example.terminalcommand_dagger2.Categories

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.adapters.CategoriesAdapter
import com.example.terminalcommand_dagger2.base.BaseFragment
import com.example.terminalcommand_dagger2.models.CategoriesModel
import kotlinx.android.synthetic.main.fragment_categories.*
import javax.inject.Inject


class CategoriesFragment
@Inject
constructor(var presenter: CategoryFragmentPresenter<CategoryFragmentMvpView>) :
    BaseFragment(),
    CategoryFragmentMvpView, Interface_sendId {

    lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_categories, container, false)
        presenter.onAttach(this)
        presenter.getCategories()

        return root
    }

    override fun loadDataCategoryList(
        categoryList: List<CategoriesModel>
    ) {
        adapter = CategoriesAdapter(requireContext(), categoryList, this)
        fragment_about_category_rcyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        fragment_about_category_rcyclerView.adapter = adapter
    }


    override fun onItemClick(position: Int) {

        presenter.setCommandListFragment(position, requireContext())
    }


}

