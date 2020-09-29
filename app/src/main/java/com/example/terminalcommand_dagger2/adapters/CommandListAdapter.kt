package com.example.terminalcommand_dagger2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.models.CommandModel
import org.w3c.dom.Text

class CommandListAdapter(var context: Context, var liste: List<CommandModel>?) :
    RecyclerView.Adapter<CommandListAdapter.define>() {
    inner class define(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var commandListAdapter_catogory_textView: TextView? = null
        var commandlistAdapter_aboutCategory: TextView? = null

        init {
            commandListAdapter_catogory_textView =
                itemView.findViewById<TextView>(R.id.layout_CategoriesOfCommand_categoryName_TextView)
            commandlistAdapter_aboutCategory =
                itemView.findViewById(R.id.layout_CategoriesOfCommand_aboutCategory_TextView)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): define {
        val commandLayout =
            LayoutInflater.from(context).inflate(R.layout.layoutcategoriesofcommand, parent, false)
        return define(commandLayout)
    }

    override fun getItemCount(): Int {
        return liste!!.size
    }

    override fun onBindViewHolder(holder: define, position: Int) {
        holder.commandlistAdapter_aboutCategory!!.text = liste!!.get(position).detail.toString()
        holder.commandListAdapter_catogory_textView!!.text = liste!!.get(position).text .toString()
    }


}