package com.home.pokemondemo2.model.remote;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface HomeService {

    @GET("d3cd2f89-aaa4-4acc-9f17-473a7a555f62?scope=resourceAquire&limit=100")
    Observable<HomeResponse> getResponse();
}
