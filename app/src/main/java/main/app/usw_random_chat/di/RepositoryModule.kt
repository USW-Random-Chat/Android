package main.app.usw_random_chat.di

import main.app.usw_random_chat.domain.repository.ChatRepository
import main.app.usw_random_chat.domain.repository.ProfileRepository
import main.app.usw_random_chat.domain.repository.SignInRepository
import main.app.usw_random_chat.domain.repository.SignUpRepository
import main.app.usw_random_chat.domain.repository.UserModifyRepository
import main.app.usw_random_chat.data.repositoryimpl.ChatRepositoryImpl
import main.app.usw_random_chat.data.repositoryimpl.ProfileRepositoryImpl
import main.app.usw_random_chat.data.repositoryimpl.SignInRepositoryImpl
import main.app.usw_random_chat.data.repositoryimpl.SignUpRepositoryImpl
import main.app.usw_random_chat.data.repositoryimpl.UserModifyRepositoryImpl
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