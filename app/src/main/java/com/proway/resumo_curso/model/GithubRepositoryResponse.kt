package com.proway.resumo_curso.model

import com.google.gson.annotations.SerializedName

data class GithubRepositoryResponse(
    @SerializedName("total_count")
    val total: Long,
    @SerializedName("items")
    val items: List<GithubModel>
)

data class GithubModel(
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("forks_count")
    val forks: Long,
    @SerializedName("language")
    val language: String,
    @SerializedName("stargazers_count")
    val stars: Long,
    @SerializedName("owner")
    val owner: GithubOwner,
    @SerializedName("html_url")
    val url: String,
)

data class GithubOwner(
    val id: Long,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("login")
    val username: String
)