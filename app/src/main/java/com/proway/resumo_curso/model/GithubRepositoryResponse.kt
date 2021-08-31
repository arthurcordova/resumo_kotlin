package com.proway.resumo_curso.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GithubRepositoryResponse(
    @SerializedName("total_count")
    val total: Long,
    @SerializedName("items")
    val items: List<GithubModel>
)

@Entity
data class GithubModel(
    @PrimaryKey
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
    @Embedded
    @SerializedName("owner")
    val owner: GithubOwner,
    @SerializedName("html_url")
    val url: String,
)

@Entity
data class GithubOwner(
    @PrimaryKey
    @ColumnInfo(name = "owner_id")
    val id: Long,
    @SerializedName("avatar_url")
    val avatar: String,
    @SerializedName("login")
    val username: String
)