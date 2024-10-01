package com.android.usw_random_chat.domain.repository

import com.android.usw_random_chat.data.dto.UserDTO

interface SignInRepository {
    suspend fun signIn(param : UserDTO) : Int

    suspend fun autoSignIn(token: String) : Int
}
