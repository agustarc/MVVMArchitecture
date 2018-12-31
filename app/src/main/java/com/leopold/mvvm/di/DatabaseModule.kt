package com.leopold.mvvm.di

import com.leopold.mvvm.data.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * @author Leopold
 */
val roomModule = module {
    single { AppDatabase.getInstance(androidApplication()) }
    single(createOnStart = false) { get<AppDatabase>().getBookmarkDao() }
}