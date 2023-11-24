package com.example.beerlens.presentation.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Index;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.beerlens.R;
import com.example.beerlens.databinding.ActivityDetailsBinding;
import com.squareup.picasso.Picasso;

public class details extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initComponents();

    }

    private void initComponents() {
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();

        binding.tvTitleBeer.setText(intent.getStringExtra("name"));
        binding.tvTitleDate.setText(intent.getStringExtra("date"));
        binding.tvDescripcion.setText(intent.getStringExtra("description"));
        binding.tvTitleTips.setText(intent.getStringExtra("tips"));
        Picasso.get().load(intent.getStringExtra("ruta")).into(binding.image);



    }
}