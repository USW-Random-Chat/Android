package com.android.usw_random_chat.data.dto.response

import com.android.usw_random_chat.data.dto.ProfileDTO
import com.google.gson.annotations.SerializedName

data class ProfileResponseDTO(
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : ProfileDTO = ProfileDTO("","","")
)
