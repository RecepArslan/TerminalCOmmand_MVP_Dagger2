package com.example.terminalcommand_dagger2.models
import com.google.gson.annotations.SerializedName


data class CategoriesModel(
    @SerializedName("iconPath")
    val iconPath:String,
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("title")
    val title: String
)