package com.home.pokemondemo2.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HomeDao {

    @Query("SELECT * FROM home_table")
    androidx.lifecycle.LiveData<java.util.List<HomeEntity>> getEntityList();

    @Insert
    void insertEntityList(java.util.List<HomeEntity> list);
}
