package com.android.usw_random_chat.di

import com.android.usw_random_chat.domain.repository.ChatRepository
import com.android.usw_random_chat.domain.repository.ProfileRepository
import com.android.usw_random_chat.domain.repository.SignInRepository
import com.android.usw_random_chat.domain.repository.SignUpRepository
import com.android.usw_random_chat.domain.repository.UserModifyRepository
import com.android.usw_random_chat.data.repositoryimpl.ChatRepositoryImpl
import com.android.usw_random_chat.data.repositoryimpl.ProfileRepositoryImpl
import com.android.usw_random_chat.data.repositoryimpl.SignInRepositoryImpl
import com.android.usw_random_chat.data.repositoryimpl.SignUpRepositoryImpl
import com.android.usw_random_chat.data.repositoryimpl.UserModifyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideSignInRepository(repositoryImpl: SignInRepositoryImpl): SignInRepository

    @Singleton
    @Binds
    abstract fun provideProfileRepository(repositoryImpl: ProfileRepositoryImpl): ProfileRepository

    @Singleton
    @Binds
    abstract fun provideSignUpRepository(repositoryImpl: SignUpRepositoryImpl): SignUpRepository

    @Singleton
    @Binds
    abstract fun provideUserModifyRepository(repositoryImpl: UserModifyRepositoryImpl): UserModifyRepository

    @Singleton
    @Binds
    abstract fun provideChatRepository(repositoryImpl: ChatRepositoryImpl): ChatRepository
}