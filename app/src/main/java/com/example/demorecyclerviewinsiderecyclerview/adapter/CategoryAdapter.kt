package com.example.demorecyclerviewinsiderecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerviewinsiderecyclerview.R
import com.example.demorecyclerviewinsiderecyclerview.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var list = mutableListOf<Category>()

    fun setData(list: MutableList<Category>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) =
        if (position == 1) TYPE_CUSTOM_IMAGE
        else TYPE_IMAGE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        if (viewType == TYPE_IMAGE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
            return ViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_category_5, parent, false)
            return ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Category) {
            itemView.imageView_category.setImageResource(item.image)
        }
    }

    companion object {
        var TYPE_IMAGE = 3
        var TYPE_CUSTOM_IMAGE = 4
    }
}
