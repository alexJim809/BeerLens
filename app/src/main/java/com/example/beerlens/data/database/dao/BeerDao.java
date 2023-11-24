package com.example.beerlens.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.beerlens.data.database.entity.BeerEntity;

import java.util.List;

@Dao
public interface BeerDao {
    @Query("Select * from Beers")
    List<BeerEntity> getAll();

    @Insert
    void insert(BeerEntity beerEntity);

    @Update
    void update ( BeerEntity beerEntity);

    @Query("Delete from Beers")
    void delete ();

}
