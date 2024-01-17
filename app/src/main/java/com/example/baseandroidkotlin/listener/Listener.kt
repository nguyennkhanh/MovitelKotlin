/*
 * Copyright (c) https://bigzun.blogspot.com/
 * Email: bigzun.com@gmail.com
 * Created by admin on 2020/5/21
 *
 */

package com.example.baseandroidkotlin.listener



interface Listener

interface RecyclerNavigator : Listener {
    fun loadBegin()
    fun loadEmpty()
    fun loadError()
    fun loadFinished()
    fun retryLoadData()
    fun autoOffWipeRefresh()
}

interface PositiveListener<T> : Listener {
    fun onPositive(result: T?)
}

interface NegativeListener<T> : Listener {
    fun onNegative(result: T?)
}

interface OnDismissListener : Listener {
    fun onDismiss()
}

interface OnNetworkChangedListener : Listener {
    fun onNetworkStateChanged(isConnected: Boolean)
}

interface OnConfigChangedListener : Listener {
    fun onConfigFuncChanged(funcId: Int = 0) {}
    fun onConfigTabChanged() {}
    fun onConfigChanged() {}
    fun onFuncHomeChanged() {}
}

interface OnUpdateUserInfoListener : Listener {
    fun onUpdateUserInfo(isAccountChanged: Boolean)
}

interface OnUpdateSurvey : Listener {
//    fun onUpdateSurvey(survey: SurveyResponse)
}

interface OnTotalUnreadNotifyChangedListener : Listener {
    fun onTotalUnreadNotifyChanged(totalUnread: Int = 0)
}

interface PositiveAddAccountFbbListener : Listener {
    fun onPositive(account: String, otp: String)
}