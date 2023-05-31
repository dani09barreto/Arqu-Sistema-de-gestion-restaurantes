package com.example.rest_admin_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rest_admin_app.databinding.RestauranteAdapterBinding;
import com.example.rest_admin_app.model.Restaurante;

import java.util.List;

public class RestauranteAdapter extends ArrayAdapter <Restaurante> {


    public RestauranteAdapter(@NonNull Context context, int resource, @NonNull List<Restaurante> objects) {
        super(context, resource, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Restaurante restaurante = getItem(position);
        RestauranteAdapterBinding binding;
        if (convertView == null) {
            binding = RestauranteAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        } else {
            binding = RestauranteAdapterBinding.bind(convertView);
        }

        binding.nombreRestaurante.setText(restaurante.getNombre());

        return binding.getRoot();
    }
}
