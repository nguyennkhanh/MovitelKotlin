package com.example.baseandroidkotlin.view.tabrelax

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment

class TabRelaxFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_home
    private lateinit var viewModel: TabRelaxViewModel


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabRelaxFragment {
            val fragment = TabRelaxFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabRelaxViewModel::class.java)
    }

    override fun initView() {

    }
}