package com.example.negociorestaurante.Controller;

import com.example.entidades.*;
import com.example.negociorestaurante.Payloads.Request.PedidoRequest;
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

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarPedido(@RequestBody PedidoRequest pedido) throws Exception {
        try {
            Mesa mesa = serviceMesa.obtenerMesa(pedido.getMesaId());
            Cliente cliente = pedido.getCliente();
            Date fecha = new Date(System.currentTimeMillis());
            EstadoPedido estadoPedido = serviceEstadoPedido.obtenerEstadoPedidoPorEstado("RECIBIDO");
            Pedido pedido1 = Pedido.builder()
                    .tiempoestado(fecha)
                    .Mesaid(mesa)
                    .Clienteid(cliente)
                    .EstadoPedidoid(estadoPedido)
                    .build();
            servicePedido.agregarPedido(pedido1);
            for (Long platoId : pedido.getPlatosId()) {
                List<IngredientePlato> ingredientesPlato = servicioPlato.obtenerIngredientesPorPlato(platoId, uri);
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
            WebSocketHandler.enviarActualizacion(pedido1);
            return ResponseEntity.ok().body("Pedido agregado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al agregar pedido");
        }

    }

    @GetMapping("/listar/indedientesplatos")
    public ResponseEntity<?> obtenerIngredientesPlatos(@RequestBody PlatosRequest platosRequest) {
        List<PlatoIngredientesResponse> platosIngredientes = new ArrayList<>();
        try {
            String uri = restClient.getResponse();
            for (Long platoId : platosRequest.getPlatosId()) {
                List<IngredientePlato> ingredientesPlato = servicioPlato.obtenerIngredientesPorPlato(platoId, uri);
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
            return ResponseEntity.ok(platosIngredientes);
        } catch (IOException | NamingException e) {
            return ResponseEntity.badRequest().body(new Mensaje("Error al obtener los ingredientes de los platos"));
        }
    }

}
