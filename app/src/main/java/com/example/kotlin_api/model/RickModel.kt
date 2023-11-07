package com.example.kotlin_api.model

import com.google.gson.annotations.SerializedName

data class RickModel(
    @SerializedName("results")
    val `result`: List<RickData>
)

data class RickData(
    @SerializedName("id")
    val `id`: Int,
    @SerializedName("name")
    val `name`: String,
    @SerializedName("species")
    val `species`: String,
)
