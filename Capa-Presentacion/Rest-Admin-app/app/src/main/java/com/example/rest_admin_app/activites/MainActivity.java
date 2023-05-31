package com.example.rest_admin_app.activites.;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.activites.AuthenticatedActivity;
import com.example.rest_admin_app.adapters.RestauranteAdapter;
import com.example.rest_admin_app.databinding.ActivityMainBinding;
import com.example.rest_admin_app.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AuthenticatedActivity {
    private ActivityMainBinding binding;
    private RestauranteAdapter adapter;
    private List <Restaurante> restaurantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new RestauranteAdapter(this, R.layout.restaurante_adapter, restaurantes);

        if (isAuthenticated()){
            if (!existeDestinoGeneral()){
                getUrlDespachador();
            }
        }

        
        binding.filledExposed.setAdapter(adapter);
    }


}