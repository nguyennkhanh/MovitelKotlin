package com.example.baseandroidkotlin

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.baseandroidkotlin.listener.ListenerUtils

class App :Application(), LifecycleObserver {
//    lateinit var listenerUtils: ListenerUtils
    companion object {
        lateinit var instance: App
            private set

        var timeStart = 0L
        var heightStatusBar = 0
        var heightNavigationBar = 0

        val CHANNEL_ID = "channel_id_default"
        var isPassToDeepLink = false
        var currentDeepLink: String? = null
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
//        listenerUtils = ListenerUtilsImpl()
    }
}
