package com.example.terminalcommand_dagger2.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.hideLoading
import com.example.terminalcommand_dagger2.showLoadingDialog

abstract class BaseFragment : Fragment(), MvpView {
    lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_categories, container, false)

        return view
    }

    override fun showLoading() {
        progressDialog = showLoadingDialog(requireContext())
    }

    override fun hideLoading() {
        hideLoading(progressDialog)
    }

    override fun showText(string: String) {
        Toast.makeText(requireContext(), string, Toast.LENGTH_LONG)
    }

}

