package com.example.envios_app.activities.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.envios_app.R;
import com.example.envios_app.databinding.DialogRestauranteBinding;

public class InfoRestauranteDialog extends Dialog {
    private final DialogRestauranteBinding binding;

    public InfoRestauranteDialog(Context context) {
        super(context);
        binding = DialogRestauranteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Obtener el tamaño de la pantalla
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // Calcular el tamaño del diálogo al 70% de la pantalla
        int dialogWidth = (int) (screenWidth * 0.7);
        int dialogHeight = (int) (screenHeight * 0.7);
        getWindow().setLayout(dialogWidth, dialogHeight);

        getWindow().setGravity(Gravity.CENTER);
        getWindow().setDimAmount(0.5f);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }


    public void dismissDialog(){
        dismiss();
    }

    public DialogRestauranteBinding getBinding() {
        return binding;
    }
}
