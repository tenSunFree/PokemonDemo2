package com.home.pokemondemo2.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.home.pokemondemo2.model.HomeRepository;
import com.home.pokemondemo2.model.db.HomeEntity;
import com.home.pokemondemo2.model.remote.HomeResponse;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HomeViewModel extends androidx.lifecycle.ViewModel {

    private HomeRepository repository;
    private androidx.lifecycle.LiveData<java.util.List<HomeEntity>> entityList;
    private MutableLiveData<java.util.List<HomeEntity>> responseList = new MutableLiveData<>();

    @ViewModelInject
    public HomeViewModel(HomeRepository repository) {
        this.repository = repository;
        entityList = repository.getEntityList();
    }

    public androidx.lifecycle.LiveData<java.util.List<HomeEntity>> getEntityList() {
        return entityList;
    }

    public MutableLiveData<java.util.List<HomeEntity>> getResponseList() {
        return responseList;
    }

    public void requestData() {
        repository.getResponse()
                .subscribeOn(Schedulers.io())
                .map(response -> {
                    java.util.List<HomeEntity> entityList = new ArrayList<>();
                    java.util.List<HomeResponse.Result.Result> resultList = response.getResult().getResults();
                    for (HomeResponse.Result.Result result : resultList) {
                        String title = "統計項目定義︰" + result.getTitle();
                        String content = "109年1-3月︰" + result.getContent() + "%";
                        content = content.replace("\n", "");
                        HomeEntity entity = new HomeEntity(title, content);
                        entityList.add(entity);
                    }
                    repository.insertEntityList(entityList);
                    return entityList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> responseList.setValue(result),
                        error -> android.util.Log.d("more", "error: " + error.getMessage()));
    }
}