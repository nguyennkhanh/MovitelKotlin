package com.example.baseandroidkotlin.view.tabpromotions

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment

class TabPromotionsUpgradeFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_promotion
    private lateinit var viewModel: TabPromotionsViewModel


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabPromotionsUpgradeFragment {
            val fragment = TabPromotionsUpgradeFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabPromotionsViewModel::class.java)
    }

    override fun initView() {

    }
}