package com.android.usw_random_chat.data.api

import com.android.usw_random_chat.data.dto.UserDTO
import com.android.usw_random_chat.data.dto.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignInApiService {
    @POST("open/member/sign-in") // 세부 주소
    @Headers("content-type: application/json")
    suspend fun registerSignIn(@Body jsonpath: UserDTO) : Response<LoginResponse>

    @POST("open/jwt/renew-token")
    @Headers("content-type: application/json")
    suspend fun autoSignIn(@Header("refreshToken") jsonpath: String ) : Response<LoginResponse>
}
