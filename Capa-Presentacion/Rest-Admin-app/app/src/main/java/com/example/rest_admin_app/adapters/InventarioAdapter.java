package com.example.rest_admin_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rest_admin_app.databinding.InventarioAdapterBinding;
import com.example.rest_admin_app.model.Inventario;

import java.util.List;

public class InventarioAdapter extends ArrayAdapter <Inventario> {

    public InventarioAdapter(@NonNull Context context, int resource, @NonNull List<Inventario> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Inventario inventario = getItem(position);
        InventarioAdapterBinding binding;

        if (convertView == null) {
            binding = InventarioAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        } else {
            binding = InventarioAdapterBinding.bind(convertView);
        }
        binding.textCantidad.setText(String.format("Cantidad: %s", inventario.getCantidad()));
        binding.textNombreIngrediente.setText(String.format("Ingrediente: %s", inventario.getIngrediente().getNombre()));
        binding.textTipoIngrediente.setText(String.format("Tipo: %s", inventario.getIngrediente().getTipoIngredienteid().getNombre()));

        return binding.getRoot();
    }

}
