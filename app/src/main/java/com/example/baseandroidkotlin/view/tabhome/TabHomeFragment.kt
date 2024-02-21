package com.example.baseandroidkotlin.view.tabhome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.example.baseandroidkotlin.R
import com.example.baseandroidkotlin.base.BaseFragment
import com.example.baseandroidkotlin.databinding.ActivityHomeBinding
import com.example.baseandroidkotlin.databinding.FragmentTabHomeBinding
import com.example.baseandroidkotlin.main.HomeActivity
import java.util.Locale

class TabHomeFragment: BaseFragment() {
    override val layoutId: Int = R.layout.fragment_tab_home
    private lateinit var viewModel: TabHomeViewModel
    private lateinit var binding: FragmentTabHomeBinding


    private val TAG_ = "TabHomeFragment"
    companion object {

        fun newInstance(bundle: Bundle? = null): TabHomeFragment {
            val fragment = TabHomeFragment()
            if (bundle != null) fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using ViewBinding
        binding = FragmentTabHomeBinding.inflate(inflater, container, false)
        binding.btnChange.setOnClickListener {
            Log.d("TabHomeFragment", "Button clicked")
            // Handle button click here
            setAppLocale(requireContext(), "vi")
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnChangeEn.setOnClickListener {
            Log.d("TabHomeFragment", "Button clicked")
            // Handle button click here
            setAppLocale(requireContext(), "en")
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(TabHomeViewModel::class.java)
    }

    override fun initView() {

    }

    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}