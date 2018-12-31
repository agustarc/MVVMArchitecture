package com.leopold.mvvm.data.remote.domain

import com.google.gson.annotations.SerializedName

/**
 * @author Leopold
 */
data class Owner(
    @SerializedName("id") val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("type") val type: String
)