package com.example.usw_random_chat.data.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("memberID")
    val memberID : String = "",
    @SerializedName("memberPW")
    val memberPW : String = "",
    @SerializedName("memberEmail")
    val memberEmail : String = ""
)


