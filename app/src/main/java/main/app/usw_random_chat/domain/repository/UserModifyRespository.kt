package main.app.usw_random_chat.domain.repository

import main.app.usw_random_chat.data.dto.PassWordDTO
import main.app.usw_random_chat.data.dto.UserDTO
import main.app.usw_random_chat.data.dto.response.PassWordCodeDTO

interface UserModifyRepository {

    suspend fun createPWChangeCode(param : main.app.usw_random_chat.data.dto.UserDTO) : Int

    suspend fun checkAuthCode(param : main.app.usw_random_chat.data.dto.response.PassWordCodeDTO) : Int

    suspend fun changePW(param : main.app.usw_random_chat.data.dto.PassWordDTO) : Int

    suspend fun findUserID(param : String) : Int

}