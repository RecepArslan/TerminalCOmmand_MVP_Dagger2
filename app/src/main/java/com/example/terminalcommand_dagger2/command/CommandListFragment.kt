package com.example.terminalcommand_dagger2.command

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentPresenter
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.adapters.CommandListAdapter
import com.example.terminalcommand_dagger2.base.BaseFragment
import com.example.terminalcommand_dagger2.key
import com.example.terminalcommand_dagger2.models.CommandModel
import com.example.terminalcommand_dagger2.showLoadingDialog
import kotlinx.android.synthetic.main.fragment_command_list.*
import kotlinx.android.synthetic.main.fragment_command_list.view.*
import kotlinx.android.synthetic.main.fragment_command_list.view.fragment_commandListFragment_rcyclerView
import javax.inject.Inject

class CommandListFragment
@Inject constructor(var presenter: CommandFragmentPresenter<CommandListFragmentMvpView>) :
    BaseFragment(),
    CommandListFragmentMvpView {
    lateinit var adapter: CommandListAdapter
    lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_command_list, container, false)
        var position = arguments!!.getString(key)
        presenter.onAttach(this)
        presenter.getCommandsOfCategory(position.toString())
        return root
    }

    override fun loadDataToList(response: List<CommandModel>?) {
        adapter = CommandListAdapter(requireContext(), response)
       fragment_commandListFragment_rcyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayout.VERTICAL, false)
        fragment_commandListFragment_rcyclerView.adapter = adapter

    }


}