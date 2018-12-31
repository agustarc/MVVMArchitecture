package com.leopold.mvvm

import com.leopold.mvvm.data.remote.api.SearchAPI
import org.koin.dsl.module.module

/**
 * @author Leopold
 */

val testApiModule = module {
    single { DummySearchAPI() as SearchAPI }
}