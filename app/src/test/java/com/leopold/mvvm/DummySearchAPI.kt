package com.leopold.mvvm

import com.leopold.mvvm.data.remote.api.SearchAPI
import com.leopold.mvvm.data.remote.response.RepositoriesResponse
import io.reactivex.Single

/**
 * @author Leopold
 */
class DummySearchAPI : SearchAPI {

    override fun search(params: MutableMap<String, String>): Single<RepositoriesResponse> {
        return Single.just(null)
    }

}