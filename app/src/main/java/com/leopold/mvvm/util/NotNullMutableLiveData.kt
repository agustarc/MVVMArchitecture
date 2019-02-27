package com.leopold.mvvm.util

import androidx.lifecycle.MutableLiveData

/**
 * @author Leopold
 */
class NotNullMutableLiveData<T : Any>(defaultValue: T) : MutableLiveData<T>() {

    init {
        value = defaultValue
    }

    override fun getValue()  = super.getValue()!!
}