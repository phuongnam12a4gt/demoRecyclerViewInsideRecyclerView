package com.example.demorecyclerviewinsiderecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerviewinsiderecyclerview.adapter.ListDataAdapter
import com.example.demorecyclerviewinsiderecyclerview.model.Category
import com.example.demorecyclerviewinsiderecyclerview.model.ListData
import com.example.demorecyclerviewinsiderecyclerview.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var listDataAdapter = ListDataAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listDataAdapter.setData(getListData(), this)
        recyclerViewData.adapter = listDataAdapter
        recyclerViewData.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getListData(): MutableList<ListData> {
        val listData = mutableListOf<ListData>()
        val listCategory = mutableListOf<Category>()
        listCategory.add(Category(R.drawable.hinh1))
        listCategory.add(Category(R.drawable.hinh2))
        listCategory.add(Category(R.drawable.hinh1))
        listCategory.add(Category(R.drawable.hinh2))
        listCategory.add(Category(R.drawable.hinh1))
        listCategory.add(Category(R.drawable.hinh2))
        val listUser = mutableListOf<User>()
        listUser.add(User("UserName1"))
        listUser.add(User("UserName2"))
        listUser.add(User("UserName3"))
        listUser.add(User("UserName4"))
        listUser.add(User("UserName5"))
        listData.add(ListData(ListDataAdapter.Companion.TYPE_CATEGORY, listCategory, null))
        listData.add(ListData(ListDataAdapter.TYPE_USER, null, listUser))
        listData.add(ListData(ListDataAdapter.TYPE_USER, null, listUser))
        listData.add(ListData(ListDataAdapter.Companion.TYPE_CATEGORY, listCategory, null))
        listData.add(ListData(ListDataAdapter.Companion.TYPE_CATEGORY, listCategory, null))
        listData.add(ListData(ListDataAdapter.TYPE_USER, null, listUser))
        return listData
    }
}
