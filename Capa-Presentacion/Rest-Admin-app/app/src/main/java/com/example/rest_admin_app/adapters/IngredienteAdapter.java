package com.example.rest_admin_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rest_admin_app.databinding.IngredienteAdapterBinding;
import com.example.rest_admin_app.model.Ingrediente;
import com.example.rest_admin_app.model.Inventario;

import java.util.List;

public class IngredienteAdapter extends ArrayAdapter <Inventario> {

    public IngredienteAdapter(@NonNull Context context, int resource, @NonNull List<Inventario> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Inventario ingrediente = getItem(position);
        IngredienteAdapterBinding binding;
        if (convertView == null) {
            binding = IngredienteAdapterBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        } else {
            binding = IngredienteAdapterBinding.bind(convertView);
        }
        binding.textNombreIngrediente.setText(ingrediente.getIngrediente().getNombre());
        binding.textCantidad.setText(String.format("Cantidad: %s", ingrediente.getCantidad()));
        binding.buttonDelete.setOnClickListener(v -> {
            remove(ingrediente);
            notifyDataSetChanged();
        });
        return binding.getRoot();
    }
}
