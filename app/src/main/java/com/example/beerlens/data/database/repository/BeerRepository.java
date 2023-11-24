package com.example.beerlens.data.database.repository;

import com.example.beerlens.data.database.entity.BeerEntity;
import com.example.beerlens.presentation.datas.BeerData;

import java.util.List;

public interface BeerRepository {
    List<BeerEntity> getBeers();
    void insert(BeerEntity beerEntity);
    void update(BeerEntity beerEntity);
    void delete();

}
