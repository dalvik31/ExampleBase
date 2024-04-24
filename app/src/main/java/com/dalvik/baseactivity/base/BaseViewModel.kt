package com.dalvik.baseactivity.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    var loading = MutableLiveData<Boolean>()
    var msgError = MutableLiveData<String>()

}