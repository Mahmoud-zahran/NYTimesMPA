package com.example.NYTimesMPA.network;

import com.example.NYTimesMPA.model.RepositoryResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */
public interface RepoApiService {

    @GET("mostpopular/v2/viewed/{period}.json")
    Observable <RepositoryResponse>  getReposData(@Path("period") String period,
    @Query("api-key") String apikey);
}

