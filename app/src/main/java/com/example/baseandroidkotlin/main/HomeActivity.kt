package com.example.baseandroidkotlin.main

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.fragment.app.FragmentTransaction
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseActivity
import com.example.baseandroidkotlin.databinding.ActivityHomeBinding
import com.example.baseandroidkotlin.utils.Constants
import com.example.baseandroidkotlin.view.tabhome.TabHomeFragment
import com.example.baseandroidkotlin.view.tabpromotions.TabPromotionsUpgradeFragment
import com.example.baseandroidkotlin.view.tabrelax.TabRelaxFragment
import com.example.baseandroidkotlin.view.tabselfcare.TabSelfcareFragment
import com.example.baseandroidkotlin.view.tabshop.TabShopFragment

class HomeActivity : BaseActivity() {

    private var mTab01Fragment: TabHomeFragment? = null
    private var mTab02Fragment: TabShopFragment? = null
    private var mTab03Fragment: TabPromotionsUpgradeFragment? = null
    private var mTab04Fragment: TabSelfcareFragment? = null
    private var mTab05Fragment: TabRelaxFragment? = null
    private var currentPosTab = -1
    private var subTabTmp = -1
    private lateinit var binding: ActivityHomeBinding

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun initView() {
        super.initView()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMainTab();
        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when (val tabId = it.itemId) {
                Constants.TAB_HOME,
                Constants.TAB_PROMOTIONS,
                Constants.TAB_SELF_CARE
                -> {
                    onClickBottomTab(tabId)
                    return@setOnNavigationItemSelectedListener true
                }
//                Constants.TAB_MOVITEL_PLUS, Constants.TAB_RELAX -> {
                Constants.TAB_RELAX -> {
//                    if (!AccountBusiness.instance.isLogin()) {
//                        openLogin()
//                        return@setOnNavigationItemSelectedListener false
//                    }
                    onClickBottomTab(tabId)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
        onClickBottomTab(Constants.TAB_HOME)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun onClickBottomTab(tabId: Int) {
        val oldPosition = currentPosTab
        switchFragment(tabId)
        val timestamp = System.currentTimeMillis()
//        if (/*timestamp - lastTimeClickBottomTab <= 1000L &&*/ oldPosition == currentPosTab)
//            lastTimeClickBottomTab = timestamp
    }

    private fun switchFragment(tabId: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (tabId) {
            Constants.TAB_HOME -> {
                mTab01Fragment?.let {
//                    it.autoFetchData()
                    transaction.show(it)
                } ?: TabHomeFragment.newInstance().let {
                    mTab01Fragment = it
//                    mTab01Fragment!!.setCallBack(this)
                    transaction.add(R.id.frame_container, it, "tab_$tabId")
                }
            }

            Constants.TAB_PROMOTIONS -> {
                mTab03Fragment?.let {
//                    it.autoFetchData()
                    transaction.show(it)
                } ?: TabPromotionsUpgradeFragment.newInstance().let {
                    mTab03Fragment = it
                    transaction.add(R.id.frame_container, it, "tab_$tabId")
                }
            }

            Constants.TAB_SELF_CARE -> {
                mTab04Fragment?.let {
//                    it.autoFetchData()
                    transaction.show(it)
                } ?: TabSelfcareFragment.newInstance().let {
                    mTab04Fragment = it
                    transaction.add(R.id.frame_container, it, "tab_$tabId")
                }
            }

            Constants.TAB_RELAX -> {
                if (mTab05Fragment == null) {
                    val bundle = Bundle()
//                    bundle.putInt(Constants.KEY_POSITION, Math.max(0, subTabTmp))
                    mTab05Fragment = TabRelaxFragment.newInstance(bundle)
                    transaction.add(R.id.frame_container, mTab05Fragment!!, "tab_$tabId")
                } else {
                    if (subTabTmp >= 0)
//                        mTab05Fragment!!.selectTabPosition(subTabTmp)
//                    mTab05Fragment!!.autoFetchData()
                        transaction.show(mTab05Fragment!!)
                }
                subTabTmp = -1
            }

            else -> {
            }
        }
        currentPosTab = getCurrentTab(tabId)
        if (currentPosTab < 0) currentPosTab = 0
        transaction.commitAllowingStateLoss()
    }

    private fun getCurrentTab(tabId: Int): Int {
        when (tabId) {
            Constants.TAB_HOME -> return 0
            Constants.TAB_PROMOTIONS -> return 1
            Constants.TAB_SELF_CARE -> return 2
            Constants.TAB_RELAX -> return 3
        }
        return -1
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        mTab01Fragment?.let { transaction.hide(it) }
        mTab02Fragment?.let { transaction.hide(it) }
        mTab03Fragment?.let { transaction.hide(it) }
        mTab04Fragment?.let { transaction.hide(it) }
        mTab05Fragment?.let { transaction.hide(it) }
    }

    private fun setupMainTab() {
        Log.d(TAG, "setupMainTab")
//        if(!isFirstTimeEnterApp){
//            viewModel.loadConfig(listener = this)
//        }
        binding.bottomNavView.menu.clear()
        binding.bottomNavView.menu.apply {
            add(
                Menu.NONE,
                Constants.TAB_HOME,
                Menu.NONE,
                getString(R.string.tab_home)
            ).setIcon(R.drawable.ic_tab_home)
            add(
                Menu.NONE,
                Constants.TAB_PROMOTIONS,    //old: TAB_SELF_CARE
                Menu.NONE,
                getString(R.string.tab_promotions)
            ).setIcon(R.drawable.ic_tab_selfcare)
            add(
                Menu.NONE,
                Constants.TAB_SELF_CARE,        //old: TAB_UTILITIES
                Menu.NONE,
                getString(R.string.tab_selfcare)
            ).setIcon(R.drawable.ic_tab_utilities)
            add(
                Menu.NONE,
                Constants.TAB_RELAX,
                Menu.NONE,
                getString(R.string.tab_relax)
            ).setIcon(R.drawable.ic_tab_relax)
        }
    }
}