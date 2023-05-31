package com.example.rest_admin_app.activites.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.databinding.DialogPedidoIngredienteBinding;

public class IngredientePedidoDialog extends Dialog {

    private DialogPedidoIngredienteBinding binding;

    public IngredientePedidoDialog(Context context) {
        super(context);
        binding = DialogPedidoIngredienteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setDimAmount(0.7f);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    public DialogPedidoIngredienteBinding getBinding() {
        return binding;
    }

    public void dismissDialog() {
        dismiss();
    }
}
