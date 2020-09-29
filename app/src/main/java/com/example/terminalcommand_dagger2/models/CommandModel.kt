package com.example.terminalcommand_dagger2.models

import com.google.gson.annotations.SerializedName

class CommandModel {
    @SerializedName("__v")
    public val V = 0

    @SerializedName("language")
    public val language: String? = null

    @SerializedName("text")
    public val text: String? = null

    @SerializedName("detail")
    public val detail: String? = null

    @SerializedName("_id")
    public val id: String? = null

    @SerializedName("category")
    public val category: String? = null

}