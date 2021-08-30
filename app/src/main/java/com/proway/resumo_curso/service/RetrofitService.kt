package com.proway.resumo_curso.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    /**
     * Cria uma instacia do retrofit passando a url base.
     * Deixamos como private pq não interessa para as outras classes, oq nos interessa
     */
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    /**
     * Retorna a interface GithubServices implementada pelo retrofit.
     */
    fun getGithubServices(): GithubServices = retrofit.create(GithubServices::class.java)
}