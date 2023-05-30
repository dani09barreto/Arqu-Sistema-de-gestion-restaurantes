package com.example.envios_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.envios_app.R;
import com.example.envios_app.REST.IUsuarioService;
import com.example.envios_app.databinding.ActivitySingUpBinding;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.model.UsuarioRequest;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.utils.RetrofitClient;

import java.math.BigInteger;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUpActivity extends BasicActivity {
    IUsuarioService usuarioService;
    ActivitySingUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        binding.backBtn.setOnClickListener(v -> {
            finish();
        });
        binding.btnCrear.setOnClickListener(v -> {
            getUrlAuth();
        });
    }

    private void getUrlAuth(){
        responseLB.getResponse(getDestinoAuth(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                singUp(ServicesRoutes.getServerAuth(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void singUp(String urlAuth){
        loadingDialog.show();
        String username = Objects.requireNonNull(binding.SingUpUsername.getEditText()).getText().toString();
        String email = Objects.requireNonNull(binding.userEmail.getEditText()).getText().toString();
        String pass = Objects.requireNonNull(binding.singUpPass.getEditText()).getText().toString();
        String name = Objects.requireNonNull(binding.userName.getEditText()).getText().toString();
        String telefono = Objects.requireNonNull(binding.userPhone.getEditText()).getText().toString();

        if (username.isEmpty()) {
            binding.SingUpUsername.setErrorEnabled(true);
            binding.SingUpUsername.setError("El nombre de usuario no puede estar vacio");
            return;
        }


        if (email.isEmpty()) {
            binding.userEmail.setErrorEnabled(true);
            binding.userEmail.setError(getString(R.string.mail_error_label));
            return;
        }

        if (pass.isEmpty()) {
            binding.singUpPass.setErrorEnabled(true);
            binding.singUpPass.setError(getString(R.string.error_pass_label));
            return;
        }

        if(name.isEmpty()){
            binding.userName.setErrorEnabled(true);
            binding.userName.setError(getString(R.string.error_name_label));
            return;
        }

        if (telefono.isEmpty()){
            binding.userPhone.setErrorEnabled(true);
            binding.userPhone.setError("El telefono no puede estar vacio");
            return;
        }

        UsuarioRequest us = new UsuarioRequest(username, pass, name, email, new BigInteger(telefono.toString()), "REPARTIDOR");
        usuarioService = RetrofitClient.getRetrofitInstance(urlAuth).create(IUsuarioService.class);
        Call <String> call = usuarioService.singUp(us);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                loadingDialog.dismiss();
                if(response.isSuccessful()){
                    alertsHelper.shortToast(getApplicationContext(),"Usuario creado correctamente");
                    finish();
                }else{
                    alertsHelper.shortToast(getApplicationContext(), response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(),"Error al crear el usuario");
                loadingDialog.dismiss();
            }
        });
    }
}