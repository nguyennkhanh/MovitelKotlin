/*
 * Copyright (c) https://bigzun.blogspot.com/
 * Email: bigzun.com@gmail.com
 * Created by namnh40 on 2020/8/7
 *
 */

package com.example.baseandroidkotlin.listener


interface ListenerUtils {
	fun addListener(listener: Listener?)
	fun removerListener(listener: Listener?)
	fun notifyNetworkChanged(isConnected: Boolean)
	fun notifyConfigFuncChanged(funcId: Int)
	fun notifyConfigTabChanged()
	fun notifyTotalUnreadNotifyChanged(totalUnread: Int)
	fun notifyUpdateUserInfo(isAccountChanged: Boolean)
	fun notifyUpdateConfig()
	fun notifyUpdateFuncHome()
	fun notifyInvalidToken(message: String?, dismissToHome: Boolean = true)
	fun notifyUpdateLanguage()
}