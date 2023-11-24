package com.example.beerlens.data.database.repositoryImplements;

import com.example.beerlens.data.database.dao.BeerDao;
import com.example.beerlens.data.database.entity.BeerEntity;
import com.example.beerlens.data.database.repository.BeerRepository;
import com.example.beerlens.presentation.datas.BeerData;

import java.util.List;

public class BeerRepositoryImpl implements BeerRepository {

    public BeerRepositoryImpl(BeerDao beerDao) {
        this.beerDao = beerDao;
    }

    BeerDao beerDao;

    @Override
    public List<BeerEntity> getBeers() {
        return beerDao.getAll();
    }

    @Override
    public void insert(BeerEntity beerEntity) {
        beerDao.insert(beerEntity);
    }

    @Override
    public void update(BeerEntity beerEntity) {
        beerDao.update(beerEntity);
    }

    @Override
    public void delete() {
        beerDao.delete();
    }
}
