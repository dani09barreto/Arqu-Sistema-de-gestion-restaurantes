package com.example.negociorestaurante.Controller;


import com.example.modeloRestaurante.entidades.Pago;
import com.example.modeloRestaurante.entidades.Pedido;
import com.example.modeloRestaurante.entidades.RegistroPago;
import com.example.modeloRestaurante.entidades.TipoPago;
import com.example.negociorestaurante.Payloads.Request.PagoRequest;
import com.example.negociorestaurante.Services.intf.IServicePago;
import com.example.negociorestaurante.Services.intf.IServiceRegistroPago;
import com.example.negociorestaurante.Services.intf.IServiceTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/api/restaurante/pago")
public class ControllerPago {
    @Autowired
    @Qualifier("servicePago")
    IServicePago servicePago;
    @Autowired
    @Qualifier("serviceTipoPago")
    IServiceTipoPago serviceTipoPago;
    @Autowired
    @Qualifier("serviceRegistroPago")
    IServiceRegistroPago serviceRegistroPago;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarPago(@RequestBody PagoRequest pagoRequest) throws Exception {
        try {
            TipoPago tipopago = serviceTipoPago.obtenerTipoPagoPorNombre(pagoRequest.getTipoPago());
            Pedido pedido = pagoRequest.getPedido();
            Pago pago = Pago.builder().Pedidoid(pedido)
                    .tipopagoid(tipopago)
                    .descuento(pagoRequest.getDescuento())
                    .valor(pagoRequest.getValor())
                    .build();
            servicePago.agregarPago(pago);
            RegistroPago regis = RegistroPago.builder().fecha(new Date()).Pagoid(pago).build();
            serviceRegistroPago.agregarRegistroPago(regis);
            return ResponseEntity.ok("Pago agregado");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al agregar el pago");
        }
    }

}
