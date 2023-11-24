package com.example.beerlens.presentation.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.beerlens.R;
import com.example.beerlens.databinding.ActivityHomeBinding;
import com.example.beerlens.domain.tools.State;
import com.example.beerlens.domain.tools.Tools;
import com.example.beerlens.presentation.adapters.BeerAdapater;
import com.example.beerlens.presentation.datas.BeerData;
import com.example.beerlens.presentation.holders.BeerHolder;
import com.example.beerlens.presentation.viewmodels.HomeViewModel;

public class Home extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;

    private BeerAdapater adapater;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        continueWithOnResume();
        initClicks();
    }

    private void initClicks() {
        binding.ivNoSignal.setOnClickListener(view -> {
            callData();
            binding.pbBeer.setVisibility(View.VISIBLE);
            binding.ivNoSignal.setVisibility(View.GONE);
        });
        binding.logOut.setOnClickListener(view1 -> {
            Tools.showAlert(this);
        });
    }

    private void initComponents() {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    private void continueWithOnResume() {
        callData();
    }

    private void callData() {
        viewModel.getBeerListLiveData().observe(this, beers -> {
            adapater = new BeerAdapater(beers);
            binding.rvBeer.setAdapter(adapater);
            binding.rvBeer.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            binding.pbBeer.setVisibility(View.GONE);
            binding.rvBeer.setVisibility(View.VISIBLE);

        });

        viewModel.getErrorLiveData().observe(this, errorMessage -> {
            switch (errorMessage){
                case State.ERROR_API:
                    Toast.makeText(this, "Error en el Api, se muestran datos de BD", Toast.LENGTH_SHORT).show();
                    binding.pbBeer.setVisibility(View.GONE);
                    binding.ivNoSignal.setVisibility(View.GONE);
                    break;
                case State.ERROR_RED:
                    Toast.makeText(this, "No tienes acceso a internet", Toast.LENGTH_SHORT).show();
                    binding.pbBeer.setVisibility(View.GONE);
                    binding.ivNoSignal.setVisibility(View.GONE);
                    break;

                case State.NO_DATA:
                    binding.pbBeer.setVisibility(View.GONE);
                    binding.rvBeer.setVisibility(View.GONE);
                    binding.ivNoSignal.setVisibility(View.VISIBLE);
                    break;
            }


        });
        viewModel.getData(this);

        viewModel.getSaludo().observe(this, s -> {
            binding.tvName.setText(s);

        });
        viewModel.getNewSaludo(this);
    }
}