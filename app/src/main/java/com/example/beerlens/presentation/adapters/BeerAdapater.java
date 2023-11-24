package com.example.beerlens.presentation.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beerlens.R;
import com.example.beerlens.presentation.datas.BeerData;
import com.example.beerlens.presentation.holders.BeerHolder;

import java.util.List;

public class BeerAdapater extends RecyclerView.Adapter <BeerHolder> {
    private final List<BeerData> beerData;

    public BeerAdapater(List<BeerData> beerData) {
        this.beerData = beerData;
    }


    @NonNull
    @Override
    public BeerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        return new BeerHolder(layoutInflater.inflate(R.layout.item_beer,parent,false)   );
    }

    @Override
    public void onBindViewHolder(@NonNull BeerHolder holder, int position) {

        holder.bind(beerData.get(position).getName(),
                    beerData.get(position).getImage_url(),
                    beerData.get(position).getId(),
                    beerData.get(position).getFirst_brewed(),
                    beerData.get(position).getDescription(),
                    beerData.get(position).getBrewers_tips());

    }

    @Override
    public int getItemCount() {
        return beerData.size();
    }
}
