package com.example.themovies.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TranslateModel(
    @SerializedName("ab_name")
    @Expose
    val abName: String,
    @SerializedName("en_name")
    @Expose
    val enName: String,
    @SerializedName("language")
    @Expose
    val language: String,
    @SerializedName("tid")
    @Expose
    val tid: String,
    @SerializedName("url")
    @Expose
    val url: String
)