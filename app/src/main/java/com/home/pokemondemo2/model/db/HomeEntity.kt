package com.home.pokemondemo2.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "home_table")
class HomeEntity(
        var title: String,
        var content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}