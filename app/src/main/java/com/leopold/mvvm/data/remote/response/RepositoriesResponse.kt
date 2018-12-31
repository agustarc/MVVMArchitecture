package com.leopold.mvvm.data.remote.response

import com.google.gson.annotations.SerializedName
import com.leopold.mvvm.data.remote.domain.Repository

/**
 * @author Leopold
 */
data class RepositoriesResponse(
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val repositories: ArrayList<Repository>
)