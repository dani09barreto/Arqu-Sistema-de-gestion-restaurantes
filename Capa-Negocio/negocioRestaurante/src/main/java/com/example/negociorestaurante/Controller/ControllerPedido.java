package com.example.negociorestaurante.Controller;

import com.example.entidades.Pedido;
import com.example.entidades.PlatoR;
import com.example.negociorestaurante.Services.intf.IServicePedido;
import com.example.negociorestaurante.Services.intf.IServicePlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/restaurante/pedido")
public class ControllerPedido {
    @Autowired
    @Qualifier("servicePlato")
    IServicePlato servicePlato;

    @Autowired
    @Qualifier("servicePedido")
    IServicePedido servicePedido;

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPedido(@RequestBody Pedido pedido){
        for (PlatoR p :pedido.get)

    }

}
