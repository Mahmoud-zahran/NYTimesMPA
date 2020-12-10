package com.example.NYTimesMPA.di;

import com.example.NYTimesMPA.BuildConfig;
import com.example.NYTimesMPA.network.RepoApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 * edited 10, Dec, 2020
 */

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {
    private static OkHttpClient.Builder okHttpClientBuilder;
    private static HttpLoggingInterceptor loggingInterceptor;
    @Provides
    @Singleton
    public static RepoApiService provideRepoApiService(){
        okHttpClientBuilder = new OkHttpClient.Builder();/// I must use OkHttpClient.Builder to add the log interceptor to the request
        okHttpClientBuilder.connectTimeout(150, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(150, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(150, TimeUnit.SECONDS);
        okHttpClientBuilder.retryOnConnectionFailure(true);
        loggingInterceptor = new HttpLoggingInterceptor(); /// I must use HttpLoggingInterceptor to could identify log configuration
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); /// add the log level body, header or ... etc
        if(BuildConfig.DEBUG){
            // only enable log in depug mode to still secure my requests like password ..
            okHttpClientBuilder.addInterceptor(loggingInterceptor);
        }
        return  new Retrofit.Builder()
                .baseUrl(" https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
                .create(RepoApiService.class);
    }
}
