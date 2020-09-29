package com.example.terminalcommand_dagger2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.terminalcommand_dagger2.Categories.Interface_sendId
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.models.CategoriesModel

class CategoriesAdapter(val context: Context,val liste: List<CategoriesModel>,val interface_sendId: Interface_sendId)

: RecyclerView.Adapter<CategoriesAdapter.define>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.define {
        val catogoryLayout =
            LayoutInflater.from(context).inflate(R.layout.layout_home_catogories, parent, false)
        return define(catogoryLayout)
    }

    override fun getItemCount(): Int {
        return liste.size
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.define, position: Int) {
        holder.categoryAdapter_catogory_textView!!.text = liste!!.get(position).title.toString()
    }

    inner class define(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        var categoryAdapter_catogory_textView: TextView? = null
        var linearLayout: LinearLayout? = null

        init {
            categoryAdapter_catogory_textView =
                itemView.findViewById(R.id.layout_home_catogories_catogory_textView)
            linearLayout = itemView.findViewById(R.id.layout_home_catogories_clickableId)
            itemView.setOnClickListener(View.OnClickListener {
                interface_sendId.onItemClick(adapterPosition)
            })
        }

    }


}
