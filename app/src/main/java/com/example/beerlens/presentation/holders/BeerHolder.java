package com.example.beerlens.presentation.holders;

import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beerlens.databinding.ItemBeerBinding;
import com.example.beerlens.presentation.ui.details.details;
import com.squareup.picasso.Picasso;

public class BeerHolder extends RecyclerView.ViewHolder {
    private final ItemBeerBinding binding;
    public BeerHolder(@NonNull View itemView) {
        super(itemView);
        binding = ItemBeerBinding.bind(itemView);
    }
    public void bind(String title, String ruta, String id, String date, String description, String brewersTips) {
        Picasso.get().load(ruta).into(binding.ivBeer);
        binding.tvTitleBeer.setText(title);
        binding.tvTitleDate.setText(date);

        binding.showAll.setOnClickListener(v -> {
            v.getContext().startActivity(new Intent(v.getContext(), details.class)
                    .putExtra("name",title)
                    .putExtra("ruta", ruta)
                    .putExtra("date",date)
                    .putExtra("description",description)
                    .putExtra("tips",brewersTips));
//                Intent intent = new Intent(v.getContext(), Descripcion.class);
//                intent.putExtra("id", id);
//                v.getContext().startActivity(intent);
        });

    }
}
