package com.home.pokemondemo2.common.di;

import android.app.Application;

import androidx.room.Room;

import com.home.pokemondemo2.model.db.HomeDB;
import com.home.pokemondemo2.model.db.HomeDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class LocalModule {

    @Provides
    @Singleton
    public static HomeDB provideHomeDB(Application application) {
        return Room.databaseBuilder(application, HomeDB.class, "Home Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static HomeDao provideHomeDao(HomeDB db) {
        return db.homeDao();
    }
}
