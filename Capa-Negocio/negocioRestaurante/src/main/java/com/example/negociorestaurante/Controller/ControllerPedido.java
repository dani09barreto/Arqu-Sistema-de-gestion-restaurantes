package com.example.negociorestaurante.Controller;

import com.example.entidades.*;
import com.example.negociorestaurante.Payloads.Request.PedidoRequest;
import com.example.negociorestaurante.Payloads.Response.PedidoResponse;
import com.example.negociorestaurante.Payloads.Response.PlatoIngredientesResponse;
import com.example.negociorestaurante.Payloads.Response.PlatoResponse;
import com.example.negociorestaurante.Services.intf.*;
import com.example.negociorestaurante.WebSocket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/restaurante/pedido")
public class ControllerPedido {
    @Autowired
    @Qualifier("servicePlatoPedido")
    IServicePlatoPedido servicePlatoPedido;

    @Autowired
    @Qualifier("servicePedido")
    IServicePedido servicePedido;

    @Autowired
    @Qualifier("serviceMesa")
    IServiceMesa serviceMesa;
    @Autowired
    @Qualifier("serviceCliente")
    IServiceCliente serviceCliente;
    @Autowired
    @Qualifier("serviceEstadoPedido")
    IServiceEstadoPedido serviceEstadoPedido;
    @Autowired
    @Qualifier("serviceIngredientePlato")
    IServiceIngredientePlato serviceIngredientePlato;

    @Autowired
    @Qualifier("serviceInventario")
    IServiceInventario serviceInventario;


    @PostMapping("/agregar")
    public ResponseEntity<?> agregarPedido(@RequestBody PedidoRequest pedido) throws Exception {
        try {
            Mesa mesa = serviceMesa.obtenerMesa(pedido.getMesaId());
            Cliente cliente = pedido.getCliente();
            cliente = serviceCliente.obtenerClientePorEmail(cliente.getEmail());
            if (cliente == null) {
                cliente = serviceCliente.agregarCliente(cliente);
            }
            EstadoPedido estadoPedido = serviceEstadoPedido.obtenerEstadoPedidoPorEstado("RECIBIDO");
            Pedido pedido1 = Pedido.builder()
                    .tiempoestado(new java.util.Date())
                    .Mesaid(mesa)
                    .Clienteid(cliente)
                    .EstadoPedidoid(estadoPedido)
                    .build();
            pedido1 = servicePedido.agregarPedido(pedido1);
            for (Long platoId : pedido.getPlatosId()) {
                PlatoPedido platoPedido = PlatoPedido.builder()
                        .Pedidoid(pedido1)
                        .cantidad(0)
                        .Platoid(platoId)
                        .build();
                servicePlatoPedido.agregarPlatoPedido(platoPedido);
            }

            List<PlatoIngredientesResponse> platosIngredientes = new ArrayList<>();
            for (Long platoId : pedido.getPlatosId()) {
                List<IngredientePlato> ingredientesPlato = serviceIngredientePlato.obtenerIngredientesPlato(platoId);
                Plato plato = ingredientesPlato.get(0).getPlato();
                PlatoResponse platoResponse = PlatoResponse.builder()
                        .id(plato.getId())
                        .nombre(plato.getNombre())
                        .precio(plato.getPrecio())
                        .descripcion(plato.getDescripcion())
                        .imagen(plato.getImg())
                        .build();
                List<Ingrediente> ingredientes = new ArrayList<>();
                for (IngredientePlato ingredientePlato : ingredientesPlato) {
                    ingredientes.add(ingredientePlato.getIngrediente());
                }
                platosIngredientes.add(PlatoIngredientesResponse.builder()
                        .plato(platoResponse)
                        .ingredientes(ingredientes)
                        .build());
            }
            PedidoResponse pedidoResponse = PedidoResponse.builder()
                    .idPedido(pedido1.getId()).lista_plato(platosIngredientes).build();
            WebSocketHandler.enviarActualizacion(pedidoResponse);
            return ResponseEntity.ok().body("Pedido agregado existosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Pedido no agregado[!]");
        }

    }

    @PostMapping("/modificar/Preparacion")
    public ResponseEntity<?> ModificarEstadoPedido(@RequestBody PedidoResponse pedido) {
        try {
            Pedido pedido1 = servicePedido.obtenerPedido(pedido.getIdPedido());
            pedido1.setEstadoPedidoid(serviceEstadoPedido.obtenerEstadoPedidoPorEstado("EN PREPARACION"));
            servicePedido.actualizarPedido(pedido1);
            //Actualizar el inventario
            for (PlatoIngredientesResponse p : pedido.getLista_plato()) {
                List<IngredientePlato> ingredientesPlato = serviceIngredientePlato.obtenerIngredientesPlato(p.getPlato().getId());
                for (IngredientePlato ip : ingredientesPlato) {
                    InventarioR inven = serviceInventario.obtenerInvetarioporIngrediente(ip.getIngrediente().getId());
                    inven.setCantidad(inven.getCantidad() - ip.getCantidad());
                    serviceInventario.actualizarInventario(inven);
                }
            }
            return ResponseEntity.ok().body(pedido1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/modificar/Entregado")
    public ResponseEntity<?> ModificarEstadoPedidoEntregado(@RequestBody Pedido pedido) {
        try {
            Pedido pedido1 = servicePedido.obtenerPedido(pedido.getId());
            pedido1.setEstadoPedidoid(serviceEstadoPedido.obtenerEstadoPedidoPorEstado("ENTREGADO"));
            servicePedido.actualizarPedido(pedido1);
            return ResponseEntity.ok().body(pedido1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}
