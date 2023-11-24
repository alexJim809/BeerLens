package com.example.beerlens.presentation.viewmodels;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.beerlens.data.database.AppDataBase;
import com.example.beerlens.data.database.dao.BeerDao;
import com.example.beerlens.data.database.entity.BeerEntity;
import com.example.beerlens.data.database.repository.BeerRepository;
import com.example.beerlens.data.database.repositoryImplements.BeerRepositoryImpl;
import com.example.beerlens.data.helpers.BeerRetrofitClient;
import com.example.beerlens.data.interfaces.RequestBeer;
import com.example.beerlens.domain.tools.State;
import com.example.beerlens.domain.tools.Tools;
import com.example.beerlens.presentation.datas.BeerData;

import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<List<BeerData>> beerListLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> errorLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> saludoLiveData = new MutableLiveData<>();

    public MutableLiveData<List<BeerData>> getBeerListLiveData() {
        return beerListLiveData;
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }
    public MutableLiveData<String> getSaludo (){
        return saludoLiveData;
    }

    public void getData(Context context) {
        RequestBeer requestBeer = BeerRetrofitClient.getRetrofitInstance().create(RequestBeer.class);
        Call<List<BeerData>> call = requestBeer.getBeers();
        call.enqueue(new Callback<List<BeerData>>() {
            @Override
            public void onResponse(Call<List<BeerData>> call, Response<List<BeerData>> response) {
                if (response.isSuccessful()) {
                    List<BeerData> beers = response.body();
                    beerListLiveData.setValue(beers);
                    setDataBase(beers, context);
                } else {
                    if (getDataBase(context).size()>0){
                        errorLiveData.setValue(State.ERROR_API);
                        beerListLiveData.setValue(getDataBase(context));
                    }else {
                        errorLiveData.setValue(State.NO_DATA);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<BeerData>> call, Throwable t) {
                // Maneja los errores de red aquí
                if (getDataBase(context).size()>0){
                    errorLiveData.setValue(State.ERROR_RED);
                    beerListLiveData.setValue(getDataBase(context));
                }else {
                    errorLiveData.setValue(State.NO_DATA);
                }
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    private List<BeerData> getDataBase(Context context) {
        AppDataBase dataBase = AppDataBase.getInstance(context.getApplicationContext());
        BeerDao beerDao = dataBase.beerDao();
        BeerRepository beerRepository = new BeerRepositoryImpl(beerDao);
        List<BeerEntity> beerEntities = beerRepository.getBeers();
        return Tools.CastList(beerEntities);
    }

    private void setDataBase(List<BeerData> beers, Context context) {

        AppDataBase dataBase = AppDataBase.getInstance(context.getApplicationContext());
        BeerDao beerDao = dataBase.beerDao();
        BeerRepository beerRepository = new BeerRepositoryImpl(beerDao);
        beerRepository.delete();
        for (BeerData beerData : beers) {
            BeerEntity beerEntity = new BeerEntity();
            beerEntity.setId(beerData.getId());
            beerEntity.setName(beerData.getName());
            beerEntity.setImage_url(beerData.getImage_url());
            beerEntity.setFirst_brewed(beerData.getFirst_brewed());
            beerEntity.setDescription(beerData.getDescription());
            beerRepository.insert(beerEntity);

        }

    }

    public void getNewSaludo (Context context)
    {
        String saludo = Tools.getSaludo(Tools.getTime());
        String nombre = Tools.getUserPreferences(context).getUserName();
        saludoLiveData.setValue(saludo +"\n"+nombre);
    }
}
