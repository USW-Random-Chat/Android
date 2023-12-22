package com.example.usw_random_chat.data.repositoryimpl

import com.example.usw_random_chat.data.api.PwChangeApiService
import com.example.usw_random_chat.data.dto.UserDTO
import com.example.usw_random_chat.data.repository.PwChangeRepository
import javax.inject.Inject

class PwChangeRepositoryImpl @Inject constructor(private val PwChangeApiService: PwChangeApiService)  : PwChangeRepository {

    override suspend fun PwChange(param: UserDTO): UserDTO {
        val response = PwChangeApiService.registerPwChange(param)

        if (response.isSuccessful){
            return response.body()!!
        }else{
            throw Exception("Fail!!")
        }
    }
}