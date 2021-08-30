package com.proway.resumo_curso.view_model

import androidx.lifecycle.ViewModel
import com.proway.resumo_curso.repository.GithubRepository

class MainViewModel : ViewModel() {

    private val repository = GithubRepository()



    fun fetchRepositories() {
        repository.fetchRepositories(language = "Kotlin") { response, error ->


            print("")


        }
    }


}