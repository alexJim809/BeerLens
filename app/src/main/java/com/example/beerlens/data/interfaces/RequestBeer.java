package com.example.beerlens.data.interfaces;
import com.example.beerlens.presentation.datas.BeerData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestBeer {
    @GET("beers?page=1")
    Call<List<BeerData>> getBeers();
}
