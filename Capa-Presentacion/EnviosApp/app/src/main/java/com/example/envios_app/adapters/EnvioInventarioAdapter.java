package com.example.envios_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.envios_app.databinding.EnvioInventarioAdapterBinding;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.utils.DistanceUtils;

import java.util.List;

public class EnvioInventarioAdapter extends ArrayAdapter <EnvioInventario> {


    public EnvioInventarioAdapter(@NonNull Context context, int resource, @NonNull List<EnvioInventario> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        EnvioInventario envioInventario = getItem(position);
        EnvioInventarioAdapterBinding binding;
        if (convertView == null) {
            binding = EnvioInventarioAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        } else {
            binding = EnvioInventarioAdapterBinding.bind(convertView);
        }

        binding.textRestaurante.setText(String.format("Restaurante: %s", envioInventario.getRestaurante().getNombre()));
        binding.textDireccionBodega.setText(String.format("Dirección: %s", envioInventario.getBodega().getDireccion()));
        binding.textBodega.setText(String.format("Bodega: %s", envioInventario.getBodega().getNombre()));
        binding.textDireccionRestaurante.setText(String.format("Dirección: %s", envioInventario.getRestaurante().getDireccion()));

        return binding.getRoot();
    }
}
