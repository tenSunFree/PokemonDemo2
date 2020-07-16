package com.home.pokemondemo2.model;

import com.home.pokemondemo2.model.db.HomeDao;
import com.home.pokemondemo2.model.db.HomeEntity;
import com.home.pokemondemo2.model.remote.HomeResponse;
import com.home.pokemondemo2.model.remote.HomeService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class HomeRepository {

    private HomeDao dao;
    private HomeService service;

    @Inject
    public HomeRepository(HomeDao dao, HomeService service) {
        this.dao = dao;
        this.service = service;
    }

    public androidx.lifecycle.LiveData<java.util.List<HomeEntity>> getEntityList() {
        return dao.getEntityList();
    }

    public void insertEntityList(java.util.List<HomeEntity> list) {
        dao.insertEntityList(list);
    }

    public Observable<HomeResponse> getResponse() {
        return service.getResponse();
    }
}