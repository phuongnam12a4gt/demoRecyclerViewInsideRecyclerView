package com.example.demorecyclerviewinsiderecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerviewinsiderecyclerview.R
import com.example.demorecyclerviewinsiderecyclerview.model.ListData
import kotlinx.android.synthetic.main.layout_list_data.view.*

class ListDataAdapter : RecyclerView.Adapter<ListDataAdapter.ViewHolder>() {
    private var mListData = mutableListOf<ListData>()
    private var mContext: Context? = null

    fun setData(list: MutableList<ListData>, context: Context) {
        this.mContext = context
        mListData = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return mListData.get(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listData = mListData.get(position)
        if (TYPE_CATEGORY == holder.itemViewType) {
            val linearLayoutManager = LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false)
            holder.itemView.recyclerViewItem.layoutManager = linearLayoutManager
            holder.itemView.recyclerViewItem.isFocusable = false
            val categoryAdapter = CategoryAdapter()
            listData.listCategory?.let { categoryAdapter.setData(it) }
            holder.itemView.recyclerViewItem.adapter = categoryAdapter
        } else if (TYPE_USER == holder.itemViewType) {
            val linearLayoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
            holder.itemView.recyclerViewItem.layoutManager = linearLayoutManager
            holder.itemView.recyclerViewItem.isFocusable = false
            val userAdapter = UserAdapter()
            listData.listUser?.let { userAdapter.setData(it) }
            holder.itemView.recyclerViewItem.adapter = userAdapter
        }
    }

    override fun getItemCount() = mListData.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    companion object {
        var TYPE_CATEGORY = 1
        var TYPE_USER = 2
    }
}
