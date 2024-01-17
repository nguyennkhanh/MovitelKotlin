package com.example.baseandroidkotlin.view.tabselfcare

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment

class TabSelfcareFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_seff_care
    private lateinit var viewModel: TabSelfcareViewModel


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabSelfcareFragment {
            val fragment = TabSelfcareFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabSelfcareViewModel::class.java)
    }

    override fun initView() {

    }
}