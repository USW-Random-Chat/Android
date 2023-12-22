package com.example.usw_random_chat.domain.usecase

import com.example.usw_random_chat.data.dto.UserDTO
import com.example.usw_random_chat.data.repository.PwChangeRepository

class PwChangeUseCase(private val pwChangeRepository: PwChangeRepository) {

    suspend fun pwChange(param : UserDTO) : UserDTO {
        return pwChangeRepository.PwChange(param)
    }
}