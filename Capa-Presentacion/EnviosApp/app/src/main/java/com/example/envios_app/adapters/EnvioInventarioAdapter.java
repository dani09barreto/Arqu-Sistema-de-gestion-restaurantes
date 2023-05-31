package com.example.envios_app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.envios_app.activities.MainActivity;
import com.example.envios_app.activities.MapActivity;
import com.example.envios_app.databinding.EnvioInventarioAdapterBinding;
import com.example.envios_app.model.EnvioInventario;
import com.example.envios_app.model.EnvioSolicitudInventario;

import java.util.List;

public class EnvioInventarioAdapter extends ArrayAdapter <EnvioSolicitudInventario> {

    private Context context;
    private MainActivity mainActivity;

    public EnvioInventarioAdapter(@NonNull Context context, int resource, @NonNull List<EnvioSolicitudInventario> objects, MainActivity mainActivity) {
        super(context, resource, objects);
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        EnvioSolicitudInventario envioInventario = getItem(position);
        EnvioInventarioAdapterBinding binding;
        if (convertView == null) {
            binding = EnvioInventarioAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        } else {
            binding = EnvioInventarioAdapterBinding.bind(convertView);
        }

        binding.textRestaurante.setText(String.format("Restaurante: %s", envioInventario.getEnvioInventario().getRestaurante().getNombre()));
        binding.textDireccionBodega.setText(String.format("Dirección: %s", envioInventario.getEnvioInventario().getBodega().getDireccion()));
        binding.textBodega.setText(String.format("Bodega: %s", envioInventario.getEnvioInventario().getBodega().getNombre()));
        binding.textDireccionRestaurante.setText(String.format("Dirección: %s", envioInventario.getEnvioInventario().getRestaurante().getDireccion()));
        binding.buttonIr.setOnClickListener(v -> {
            mainActivity.getUrlGeneral(envioInventario);
        });

        return binding.getRoot();
    }
}
