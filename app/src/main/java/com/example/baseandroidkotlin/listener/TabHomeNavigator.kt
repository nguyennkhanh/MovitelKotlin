package com.example.baseandroidkotlin.listener

import com.example.baseandroidkotlin.model.TabHomeModel

interface TabHomeNavigator:  RecyclerNavigator {
    fun onUpdateItem(list: ArrayList<TabHomeModel>)
}