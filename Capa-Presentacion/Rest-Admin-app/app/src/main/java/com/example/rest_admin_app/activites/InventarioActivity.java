package com.example.rest_admin_app.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.REST.IDespachadorService;
import com.example.rest_admin_app.REST.IInventarioService;
import com.example.rest_admin_app.activites.dialog.IngredientePedidoDialog;
import com.example.rest_admin_app.adapters.IngredienteAdapter;
import com.example.rest_admin_app.adapters.InventarioAdapter;
import com.example.rest_admin_app.databinding.ActivityInventarioBinding;
import com.example.rest_admin_app.model.DestServer;
import com.example.rest_admin_app.model.Ingrediente;
import com.example.rest_admin_app.model.Inventario;
import com.example.rest_admin_app.model.InventarioRequests;
import com.example.rest_admin_app.model.Mensaje;
import com.example.rest_admin_app.model.ServicesRoutes;
import com.example.rest_admin_app.model.SolicitudInventario;
import com.example.rest_admin_app.utils.ResponseLB;
import com.example.rest_admin_app.utils.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InventarioActivity extends AuthenticatedActivity {

    private ActivityInventarioBinding binding;
    private InventarioAdapter adapter;
    private List <Inventario> inventario = new ArrayList<>();
    private List<Inventario> ingredientes = new ArrayList<>();
    private IngredienteAdapter ingredienteAdapter;
    private IDespachadorService despachadorService;
    private IInventarioService inventarioService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInventarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ingredienteAdapter = new IngredienteAdapter(this, R.layout.ingrediente_adapter, ingredientes);
        adapter = new InventarioAdapter(this, R.layout.inventario_adapter, inventario);

        if (existeDestinoRestaurante()){
            getUrlRestaurante();
        }else{
            getUrlDespachador();
        }

        binding.listaInventario.setAdapter(adapter);

        binding.listaInventario.setOnItemClickListener((parent, view, position, id) -> {
            Inventario inventario = (Inventario) parent.getItemAtPosition(position);
            IngredientePedidoDialog dialog = new IngredientePedidoDialog(InventarioActivity.this);
            dialog.getBinding().textBodega.setText(inventario.getIngrediente().getNombre());
            dialog.show();

            dialog.getBinding().buttonAAdir.setOnClickListener(v -> {
                String cantidad = dialog.getBinding().editTextCantidad.getText().toString();
                if (cantidad.isEmpty()) {
                    alertsHelper.shortToast(getApplicationContext(), "Ingrese una cantidad");
                    return;
                }
                int cantidadInt = Integer.parseInt(cantidad);
                ingredientes.add(new Inventario(inventario.getId(), inventario.getIngrediente(), cantidadInt));
                ingredienteAdapter.notifyDataSetChanged();
                dialog.dismiss();
            });
        });

        binding.carritoIngrediente.setAdapter(ingredienteAdapter);
        binding.button.setOnClickListener(v -> {
            alertsHelper.shortToast(getApplicationContext(), "solicitar envio");
            if (ingredientes.size() == 0){
                alertsHelper.shortToast(getApplicationContext(), "No hay ingredientes en el carrito");
                return;
            }
            crearPedidoInventario();
        });


    }

    private void crearPedidoInventario() {
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                crearPedido(headerValue);
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void crearPedido(String headerValue) {
        inventarioService = RetrofitClient.getRetrofitInstance(ServicesRoutes.getServerGeneral(headerValue), getTokenUser()).create(IInventarioService.class);
        List <InventarioRequests> inventarioRequests = new ArrayList<>();
        for (Inventario in : ingredientes){
            inventarioRequests.add(new InventarioRequests(in.getIngrediente().getId(), in.getCantidad()));
        }
        SolicitudInventario solicitudInventario = new SolicitudInventario(headerValue, inventarioRequests);
        Long id = Long.getLong(getIdRestaurante());
        Call <Mensaje> call = inventarioService.solicitarInventario(id, solicitudInventario);
        call.enqueue(new Callback<Mensaje>() {
            @Override
            public void onResponse(Call<Mensaje> call, Response<Mensaje> response) {
                if (response.isSuccessful()){
                    alertsHelper.shortToast(getApplicationContext(), "Pedido creado");
                    Intent intent = new Intent(InventarioActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    alertsHelper.shortToast(getApplicationContext(), "Error al crear pedido");
                }
            }

            @Override
            public void onFailure(Call<Mensaje> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), "Error al crear pedido");
            }
        });

    }


    private void getUrlRestaurante() {
        loadingDialog.show();
        responseLB.getResponse(getDestinoRestaurante(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                listarInventario(headerValue);
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void listarInventario(String ipRestaurante) {
        inventarioService = RetrofitClient.getRetrofitInstance(ServicesRoutes.getServerRestaurante(ipRestaurante), getTokenUser()).create(IInventarioService.class);
        Call<List<Inventario>> call = inventarioService.listarInventario();
        call.enqueue(new Callback<List<Inventario>>() {
            @Override
            public void onResponse(Call<List<Inventario>> call, Response<List<Inventario>> response) {
                if (response.isSuccessful()){
                    inventario = response.body();
                    adapter.clear();
                    adapter.addAll(inventario);
                    adapter.notifyDataSetChanged();
                    loadingDialog.dismiss();
                }else{
                    alertsHelper.shortToast(getApplicationContext(), "Error al listar inventario");
                    loadingDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<Inventario>> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), "Error al listar inventario");
                loadingDialog.dismiss();
            }
        });

    }

    protected void getUrlDespachador() {
        responseLB.getResponse(ServicesRoutes.getUrlLbDespachador(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                getUrlLBRestaurante(ServicesRoutes.getServerDespachador(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void getUrlLBRestaurante(String serverDespachador) {
        despachadorService = RetrofitClient.getRetrofitInstance(serverDespachador).create(IDespachadorService.class);
        String pathRestaurante = getPathRestaurante();
        Call<DestServer> call = despachadorService.obtenerDestino(pathRestaurante);
        call.enqueue(new Callback<DestServer>() {
            @Override
            public void onResponse(Call<DestServer> call, Response<DestServer> response) {
                if (response.isSuccessful()){
                    DestServer destServer = response.body();
                    sharedPreferences = getSharedPreferences("session_rest", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("direccionRestaurante", destServer.getDireccion());
                    editor.apply();
                    getUrlRestaurante();
                }
            }

            @Override
            public void onFailure(Call<DestServer> call, Throwable t) {

            }
        });
    }
}