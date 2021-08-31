package com.proway.resumo_curso.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.proway.resumo_curso.model.GithubModel

@Dao
interface GithubDao {

    @Insert(onConflict = REPLACE)
    fun insert(githubModels: List<GithubModel>)

    @Query("SELECT * FROM GithubModel order by name")
    fun getAll(): List<GithubModel>

    @Query("SELECT count(*) FROM GithubModel WHERE language = :language")
    fun getTotalByLanguage(language: String): Int


}