package com.proway.resumo_curso.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.resumo_curso.model.GithubModel
import com.proway.resumo_curso.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    /**
     * Lista os repositórios
     */
    private val _repositories = MutableLiveData<List<GithubModel>>()
    val repositories: LiveData<List<GithubModel>> = _repositories

    /**
     * Criado esta variavel para armazenar a paginação que o user esta atuando.
     */
    private val _page = MutableLiveData(0)
    val page: LiveData<Int> = _page

    /**
     * Sempre será chamado passando a página, caso não passe nenhuma irá passar por default 1
     */
    fun fetchRepositories(language: String, page: Int = 1) {
        repository.fetchRepositories(language = language, page = page) { response, _ ->
            response?.let { resp ->
                _repositories.value = resp.items
            }
        }
    }

    /**
     * Atualiza a página
     */
    fun nextPage() {
        _page.value = _page.value!! + 1
    }

}