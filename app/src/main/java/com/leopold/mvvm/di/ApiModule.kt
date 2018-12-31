package com.leopold.mvvm.di

import com.leopold.mvvm.data.remote.api.SearchAPI
import org.koin.dsl.module.module
import retrofit2.Retrofit

/**
 * @author Leopold
 */
val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(SearchAPI::class.java) }
}