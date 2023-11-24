package com.example.beerlens.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.beerlens.data.database.dao.BeerDao;
import com.example.beerlens.data.database.entity.BeerEntity;

@Database(entities = {BeerEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public static AppDataBase INSTANCE;
    public abstract BeerDao beerDao();
    public static AppDataBase getInstance(Context context){
        if (INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context,AppDataBase.class,"BeerDataBase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return INSTANCE;
    }
}
