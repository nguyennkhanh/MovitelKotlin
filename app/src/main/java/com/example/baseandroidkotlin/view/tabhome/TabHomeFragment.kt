package com.example.baseandroidkotlin.view.tabhome

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment

class TabHomeFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_home
    private lateinit var viewModel: TabHomeViewModel


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabHomeFragment {
            val fragment = TabHomeFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabHomeViewModel::class.java)
    }

    override fun initView() {

    }
}