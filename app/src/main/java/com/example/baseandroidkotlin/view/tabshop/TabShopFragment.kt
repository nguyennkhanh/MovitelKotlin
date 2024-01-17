package com.example.baseandroidkotlin.view.tabshop

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment

class TabShopFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_home
    private lateinit var viewModel: TabShopViewModel


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabShopFragment {
            val fragment = TabShopFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabShopViewModel::class.java)
    }

    override fun initView() {

    }
}