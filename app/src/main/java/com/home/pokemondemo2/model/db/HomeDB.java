package com.home.pokemondemo2.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HomeEntity.class}, version = 2, exportSchema = false)
public abstract class HomeDB extends RoomDatabase {

    public abstract HomeDao homeDao();
}
