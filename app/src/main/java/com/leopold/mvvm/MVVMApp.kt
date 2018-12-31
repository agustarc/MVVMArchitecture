package com.leopold.mvvm

import android.app.Application
import com.leopold.mvvm.di.apiModule
import com.leopold.mvvm.di.roomModule
import com.leopold.mvvm.di.networkModule
import com.leopold.mvvm.di.viewModelModule
import org.koin.android.ext.android.startKoin

/**
 * @author Leopold
 */
@Suppress("Unused")
class MVVMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            networkModule,
            apiModule,
            roomModule,
            viewModelModule
        ))
    }

}