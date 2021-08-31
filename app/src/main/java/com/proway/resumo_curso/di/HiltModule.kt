package com.proway.resumo_curso.di

import android.content.Context
import com.proway.resumo_curso.database.AppDatabase
import com.proway.resumo_curso.database.dao.GithubDao
import com.proway.resumo_curso.repository.GithubRepository
import com.proway.resumo_curso.service.GithubServices
import com.proway.resumo_curso.service.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGithubRepository(dao: GithubDao, services: GithubServices): GithubRepository = GithubRepository(dao, services)

    @Provides
    fun provideGithuServices(): GithubServices = RetrofitService.getGithubServices()

    @Provides
    fun provideGithubDao(@ApplicationContext context: Context): GithubDao {
        return AppDatabase.getDatabase(context).getGithubDao()
    }

}
