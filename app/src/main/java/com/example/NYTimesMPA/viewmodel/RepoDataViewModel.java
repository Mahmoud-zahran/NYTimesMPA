package com.example.NYTimesMPA.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.NYTimesMPA.model.RepositoryResponse;
import com.example.NYTimesMPA.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */

public class RepoDataViewModel extends ViewModel {
    private static final String TAG = "RepoDataViewModel";

    private Repository repository;
//    private MutableLiveData<ArrayList<RepositoryResponse.Result>> mRepoList = new MutableLiveData<ArrayList<RepositoryResponse.Result>>();
    private MutableLiveData<ArrayList<RepositoryResponse.Result>> mRepoList = new MutableLiveData<>();

    private MutableLiveData<ArrayList<RepositoryResponse.Result>> favoriteRepoList = null;
    private LiveData<List<RepositoryResponse.Result>> mResultList = null;

    @ViewModelInject
    public RepoDataViewModel(Repository repository) {
        this.repository = repository;
//        favoriteRepoList = repository.getFavoriteRepo();
    }

    public MutableLiveData<ArrayList<RepositoryResponse.Result>> getmRepoList() {
        return mRepoList;
    }

    public void getRepos(){
        repository.getReposData("7","hvhb1ip7znYQfxzQwELG02KA6dp6hFA9")
                .subscribeOn(Schedulers.io())
                .map(new Function<RepositoryResponse, ArrayList<RepositoryResponse.Result>>() {
                    @Override
                    public ArrayList<RepositoryResponse.Result> apply(RepositoryResponse repositoryResponse) throws Throwable {
                        List<RepositoryResponse.Result> list = repositoryResponse.getResults();
//                        mResultList= (LiveData<List<RepositoryResponse.Result>>) list;
                        return (ArrayList<RepositoryResponse.Result>) list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> mRepoList.setValue( result),
                        error-> Log.e(TAG, "getRepos: " + error.getMessage() ));
    }

    public void insertRepo(RepositoryResponse repositoryResponse){
        repository.insertRepo(repositoryResponse);
    }
    public void deleteRepo(String repoName){
        repository.deleteRepo(repoName);
    }

    public MutableLiveData<ArrayList<RepositoryResponse.Result>> getFavoriteRepoList() {
        favoriteRepoList= mRepoList;
        return favoriteRepoList;
    }
    public LiveData<List<RepositoryResponse.Result>> getResultList() {
        return mResultList;
    }
//    public void getFavoriteRepo(){
//       favoriteRepoList = repository.getFavoriteRepo();
//    }



}
