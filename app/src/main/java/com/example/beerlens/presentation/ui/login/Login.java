package com.example.beerlens.presentation.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.beerlens.R;
import com.example.beerlens.databinding.ActivityLoginBinding;
import com.example.beerlens.presentation.ui.home.Home;
import com.example.beerlens.presentation.viewmodels.LoginViewModel;

public class Login extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        continueWithOnResume();
    }

    private void continueWithOnResume() {
        binding.loginButton.setOnClickListener(view -> {
            if (loginViewModel.isEditTextEmpty(binding.edtName.getText().toString())){
                binding.edtName.setError("Ingresa un nombre ");
            }else {
                binding.edtName.setError(null);
                if (binding.checkboxRemember.isChecked()){
                    loginViewModel.saveData(binding.edtName.getText().toString(),this);
                }
                startActivity(new Intent(Login.this, Home.class));
                finish();

            }
        });
    }

    private void initComponents() {
        // initialized biding
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(view);
        // initialized viewModel
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

    }

}