package com.proway.resumo_curso.repository

import com.proway.resumo_curso.database.dao.GithubDao
import com.proway.resumo_curso.model.GithubRepositoryResponse
import com.proway.resumo_curso.service.GithubServices
import com.proway.resumo_curso.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Repositorio, será responsavel na interaçao com os dados que vem do Server/DAO/Firebase etc.
 * Netsa camada é onde criamos todos as funcoes precisam buscar dados, independente da sua fonte.
 */
class GithubRepository @Inject constructor(
    private val githubDao: GithubDao,
    private val githubServices : GithubServices
) {

    /**
     * Vamos expor o serviço de fetchRepositories para as outras camadas.
     */
    fun fetchRepositories(
        language: String,
        sort: String = "stars",
        page: Int = 1,
        onComplete: (GithubRepositoryResponse?, String?) -> Unit
    ) {
        val call = githubServices.fetchRepositories(
            language = "language:$language",
            sort = sort,
            page = page
        )
        call.enqueue(object : Callback<GithubRepositoryResponse> {
            override fun onResponse(
                call: Call<GithubRepositoryResponse>,
                response: Response<GithubRepositoryResponse>
            ) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                } else {
                    onComplete(null, "Erro diferente")
                }
            }

            override fun onFailure(call: Call<GithubRepositoryResponse>, t: Throwable) {
                onComplete(null, t.message)
            }
        })

    }

    fun insertIntoDb() {

    }

    fun fetchRepositoriesFromDb(language: String) {

    }


}
