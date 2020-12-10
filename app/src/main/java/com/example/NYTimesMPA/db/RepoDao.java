package com.example.NYTimesMPA.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.NYTimesMPA.model.RepositoryResponse;

import java.util.List;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */

@Dao
public interface RepoDao {

    @Insert
    void insertRepoDao(RepositoryResponse repositoryResponse);

    @Query("DELETE FROM favorite_table WHERE status = :status")
    void deleteRepoDao(String status);

    @Query("DELETE FROM favorite_table")
    void deleteAll();

    @Query("SELECT * FROM favorite_table")
    LiveData<List<RepositoryResponse>> getFavoriteRepos();
}
