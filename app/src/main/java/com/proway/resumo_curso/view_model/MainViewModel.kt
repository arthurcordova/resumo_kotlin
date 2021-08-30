package com.proway.resumo_curso.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.resumo_curso.model.GithubModel
import com.proway.resumo_curso.repository.GithubRepository

class MainViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<GithubModel>>()
    val repositories: LiveData<List<GithubModel>> = _repositories

    private val _page = MutableLiveData<Int>(0)
    val page: LiveData<Int> = _page

    private val repository = GithubRepository()

    fun fetchRepositories(language: String, page: Int = 1) {
        repository.fetchRepositories(language = language, page = page) { response, _ ->
            response?.let { resp ->
                _repositories.value = resp.items
            }
        }
    }

    fun nextPage() {
        _page.value = _page.value!! + 1
    }

    fun previousPage() {
        _page.value = _page.value!! - 1
    }

}