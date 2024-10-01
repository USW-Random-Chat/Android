package com.android.usw_random_chat.data.repositoryimpl

import android.util.Log
import com.android.usw_random_chat.data.api.ChatApiService
import com.android.usw_random_chat.data.local.TokenSharedPreference
import com.android.usw_random_chat.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatApiService: ChatApiService,
    private val tokenSharedPreference: TokenSharedPreference
) : ChatRepository {
    override suspend fun matching(accessToken: String): Int {
        val response  = chatApiService.matching(accessToken)

        return if (response.isSuccessful){
            Log.d("매칭 성공",response.body().toString())
            response.code()
        }
        else{
            Log.d("매칭 Fail",response.body().toString())
            response.code()
        }

    }


}