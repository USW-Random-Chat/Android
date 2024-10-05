package main.app.usw_random_chat.di

import main.app.usw_random_chat.data.api.ChatApiService
import main.app.usw_random_chat.data.api.ProfileApiService
import main.app.usw_random_chat.data.api.SignInApiService
import main.app.usw_random_chat.data.api.SignUpApiService
import main.app.usw_random_chat.data.api.UserModifyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideSignInApiService(retrofit: Retrofit): SignInApiService =
        retrofit.create(SignInApiService::class.java)

    @Provides
    @Singleton
    fun provideProfileApiService(retrofit: Retrofit): ProfileApiService =
        retrofit.create(ProfileApiService::class.java)

    @Provides
    @Singleton
    fun provideSignUpApiService(retrofit: Retrofit): SignUpApiService =
        retrofit.create(SignUpApiService::class.java)


    @Provides
    @Singleton
    fun provideUserModifyApiService(retrofit: Retrofit): UserModifyApiService =
        retrofit.create(UserModifyApiService::class.java)

    @Provides
    @Singleton
    fun provideChatApiService(retrofit: Retrofit): ChatApiService =
        retrofit.create(ChatApiService::class.java)

}