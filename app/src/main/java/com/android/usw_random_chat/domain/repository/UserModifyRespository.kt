package com.android.usw_random_chat.domain.repository

import com.android.usw_random_chat.data.dto.PassWordDTO
import com.android.usw_random_chat.data.dto.UserDTO
import com.android.usw_random_chat.data.dto.response.PassWordCodeDTO

interface UserModifyRepository {

    suspend fun createPWChangeCode(param : UserDTO) : Int

    suspend fun checkAuthCode(param : PassWordCodeDTO) : Int

    suspend fun changePW(param : PassWordDTO) : Int

    suspend fun findUserID(param : String) : Int

}