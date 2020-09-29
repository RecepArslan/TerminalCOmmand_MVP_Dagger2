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
import com.example.terminalcommand_dagger2.models.CategoriesModel
import com.example.terminalcommand_dagger2.showLoadingDialog
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_categories.view.*
import javax.inject.Inject


class CategoriesFragment @Inject constructor(var presenter: CategoryFragmentPresenter) : Fragment(),
    CategoryFragmentMvpView, Interface_sendId {

    lateinit var adapter: CategoriesAdapter
    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_categories, container, false)
        presenter.setView(root, this)
        presenter.getCategories()

        return root
    }

    override fun LoadDataCategoryList(
        categoryList: List<CategoriesModel>,
        root: View
    ) {
        adapter = CategoriesAdapter(requireContext(), categoryList, this)
        root.fragment_about_category_rcyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        fragment_about_category_rcyclerView.adapter = adapter
    }

    override fun showLoading() {
        progressDialog = showLoadingDialog(requireContext())
    }

    override fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog.isShowing) {
                progressDialog.dismiss()

            }
        }
    }

    override fun onItemClick(position: Int) {

        presenter.setCommandListFragment(position, requireContext())
    }


}

