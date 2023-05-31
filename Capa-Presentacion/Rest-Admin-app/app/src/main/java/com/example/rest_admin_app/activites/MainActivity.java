package com.example.rest_admin_app.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.REST.IRestaurantesServices;
import com.example.rest_admin_app.activites.AuthenticatedActivity;
import com.example.rest_admin_app.adapters.RestauranteAdapter;
import com.example.rest_admin_app.databinding.ActivityMainBinding;
import com.example.rest_admin_app.model.Restaurante;
import com.example.rest_admin_app.model.ServicesRoutes;
import com.example.rest_admin_app.utils.PermissionHelper;
import com.example.rest_admin_app.utils.ResponseLB;
import com.example.rest_admin_app.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AuthenticatedActivity {
    private ActivityMainBinding binding;
    private RestauranteAdapter adapter;
    private List <Restaurante> restaurantes = new ArrayList<>();
    private IRestaurantesServices restaurantesServices;

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
            else{
                listarRestaurantes();
            }
        }

        binding.filledExposed.setAdapter(adapter);
        binding.filledExposed.setOnItemClickListener((parent, view, position, id) -> {
            Restaurante restaurante = (Restaurante) parent.getItemAtPosition(position);
            sharedPreferences = getSharedPreferences("session_rest", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("restaurante", restaurante.getPath());
            editor.putString("idRestaurante", String.valueOf(restaurante.getId()));
            editor.apply();
            startActivity(new Intent(this, InventarioActivity.class));
        });
    }

    public void getUrlGeneral(){
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                consultarRestaurantes(headerValue);
            }
            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void consultarRestaurantes(String headerValue) {
        restaurantesServices =  RetrofitClient.getRetrofitInstance(ServicesRoutes.getServerGeneral(headerValue)).create(IRestaurantesServices.class);
        Call <List<Restaurante>> call = restaurantesServices.listarRestaurantes();

        call.enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (!response.isSuccessful()){
                    alertsHelper.shortToast(getApplicationContext(), "Error: " + response.code());
                    return;
                }
                restaurantes.clear();
                restaurantes.addAll(response.body());
                adapter.notifyDataSetChanged();
                loadingDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), t.getMessage());
            }
        });
    }

    public void listarRestaurantes() {
        loadingDialog.show();
        getUrlGeneral();
    }

    @Override
    protected void onStart() {
        super.onStart();
        permissionHelper.getLocationPermission(this);
        if (permissionHelper.isMLocationPermissionGranted()) {
            locationService.startLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionHelper.PERMISSIONS_LOCATION) {
            permissionHelper.getLocationPermission(this);
            if (permissionHelper.isMLocationPermissionGranted()) {
                locationService.startLocation();
            }
        }
    }


}