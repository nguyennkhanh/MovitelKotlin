package com.example.baseandroidkotlin.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.baseandroidkotlin.App
import com.example.baseandroidkotlin.listener.OnChangeLanguageListener

abstract class BaseActivity : AppCompatActivity(), BaseActivityListener, OnChangeLanguageListener {
    protected val TAG = javaClass.canonicalName
    private var timeStartOnCreate: Long = 0
    var isPaused = false
    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        timeStartOnCreate = System.currentTimeMillis()
        isPaused = false
        initData(intent = intent, isNewIntent = false)
        setTheme()
        setContentView(layoutId)
        initView()
        addListener()
        setTransitionOnCreate()
    }

    override fun initData(intent: Intent?, isNewIntent: Boolean) {
//        TODO("Not yet implemented")
    }

    override fun initView() {
//        TODO("Not yet implemented")
    }

    override fun setTheme() {
//        TODO("Not yet implemented")
    }

    override fun setTransitionOnCreate() {
//        TODO("Not yet implemented")
    }

    override fun setTransitionOnFinnish() {
//        TODO("Not yet implemented")
    }

    override fun onFragmentAttached(tag: String) {
//        TODO("Not yet implemented")
    }

    override fun onFragmentDetached(tag: String) {
//        TODO("Not yet implemented")
    }

    fun addListener() {
//        App.instance.listenerUtils.removerListener(this)
//        App.instance.listenerUtils.addListener(this)
    }

    override fun onLanguageAppChanged() {
        Log.d(TAG, "onLanguageAppChanged")
    }
}

interface BaseActivityListener {
    fun initData(intent: Intent?, isNewIntent: Boolean)
    fun initView()
    fun setTheme()
    fun setTransitionOnCreate()
    fun setTransitionOnFinnish()
    fun onFragmentAttached(tag: String)
    fun onFragmentDetached(tag: String)
}