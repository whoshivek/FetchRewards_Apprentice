package com.example.fetchrewards.model


import com.google.gson.annotations.SerializedName

data class InformationItems(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("listId")
    val listId: Int?,
    @SerializedName("name")
    val name: String?
    )