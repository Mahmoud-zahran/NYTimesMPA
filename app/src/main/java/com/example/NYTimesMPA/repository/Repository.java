package com.example.NYTimesMPA.repository;

import androidx.lifecycle.LiveData;

import com.example.NYTimesMPA.db.RepoDao;

import com.example.NYTimesMPA.model.RepositoryResponse;
import com.example.NYTimesMPA.network.RepoApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */

public class Repository {

    private RepoDao repoDao;
    private RepoApiService apiService;

    @Inject
    public Repository(RepoDao repoDao, RepoApiService apiService) {
        this.repoDao = repoDao;
        this.apiService = apiService;
    }


    public Observable<RepositoryResponse> getReposData(String period
            , String apiKey){
        return apiService.getReposData(period,apiKey);
    }

    public void insertRepo(RepositoryResponse repositoryResponse){
        repoDao.insertRepoDao(repositoryResponse);
    }

    public void deleteRepo(String repo)
    {
        repoDao.deleteRepoDao(repo);
    }

    public void deleteAll(){
        repoDao.deleteAll();
    }

    public LiveData<List<RepositoryResponse>> getFavoriteRepo(){
        return repoDao.getFavoriteRepos();
    }
}
