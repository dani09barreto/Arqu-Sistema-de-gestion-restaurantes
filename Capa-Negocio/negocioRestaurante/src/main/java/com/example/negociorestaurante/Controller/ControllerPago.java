package com.example.negociorestaurante.Controller;


import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesPagoService;
import com.example.modeloRestaurante.entidades.*;
import com.example.negociorestaurante.Payloads.Request.PagoRequest;
import com.example.negociorestaurante.Services.intf.*;
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

    @Autowired
    @Qualifier("serviceAdicionales")
    IServiceAdicionales serviceAdicionales;
    @Autowired
    @Qualifier("serviceAdicionalesPago")
    IServiceAdicionalesPago serviceAdicionalesPago;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarPago(@RequestBody PagoRequest pagoRequest) throws Exception {
        try {
            TipoPago tipopago = serviceTipoPago.obtenerTipoPagoPorNombre(pagoRequest.getTipoPago());
            Pedido pedido = pagoRequest.getPedido();
            Pago pago = Pago.builder().Pedidoid(pedido)
                    .tipopagoid(tipopago)
                    .descuento(0d)
                    .valor(pagoRequest.getValor())
                    .build();
            servicePago.agregarPago(pago);
            for(String s: pagoRequest.getAdiciones()){
                Adicionales adicion = serviceAdicionales.obtenerAdicionalporNombre(s);
                pago.setValor(pago.getValor()*adicion.getValor());
                AdicionalesPago adicionpago = AdicionalesPago.builder().Pagoid(pago).Adicionalesid(adicion).build();
                serviceAdicionalesPago.AgregarAdicionalesPago(adicionpago);
            }

            RegistroPago regis = RegistroPago.builder().fecha(new Date()).Pagoid(pago).build();
            serviceRegistroPago.agregarRegistroPago(regis);
            return ResponseEntity.ok(pago.getValor());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(0);
        }
    }

}
