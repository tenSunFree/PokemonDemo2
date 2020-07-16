package com.home.pokemondemo2.common.di;

import com.home.pokemondemo2.model.remote.HomeService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class RemoteModule {

    @Provides
    @Singleton
    public static HomeService provideHomeService() {
        return new Retrofit.Builder()
                .baseUrl("https://data.taipei/api/v1/dataset/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(HomeService.class);
    }
}
