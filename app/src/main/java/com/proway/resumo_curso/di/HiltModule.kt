package com.proway.resumo_curso.di

import com.proway.resumo_curso.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGithubRepository() : GithubRepository = GithubRepository()

}
