package com.example.NYTimesMPA.di;

import android.app.Application;

import androidx.room.Room;

import com.example.NYTimesMPA.db.RepoDao;
import com.example.NYTimesMPA.db.RepoDataDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Created by Mahmoud Zahran on 2,Oct,2020
 */

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static RepoDataDB provideUnionCoopDB(Application application){
         return Room.databaseBuilder(application, RepoDataDB.class,"Favorite Database")
                 .fallbackToDestructiveMigration()
                 .allowMainThreadQueries()
                 .build();
    }

    @Provides
    @Singleton
    public static RepoDao providePokeDao(RepoDataDB repoDataDB){
        return repoDataDB.pokeDao();
    }
}
