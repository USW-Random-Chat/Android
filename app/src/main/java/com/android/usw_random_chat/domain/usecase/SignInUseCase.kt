package com.android.usw_random_chat.domain.usecase

import com.android.usw_random_chat.data.dto.UserDTO
import com.android.usw_random_chat.domain.repository.SignInRepository

class SignInUseCase(private val signInRepository: SignInRepository) {
    suspend fun execute(param : UserDTO) : Int {
        return signInRepository.signIn(param)
    }

    suspend fun autoSignIn(token: String) : Int {
        return signInRepository.autoSignIn(token)
    }
}