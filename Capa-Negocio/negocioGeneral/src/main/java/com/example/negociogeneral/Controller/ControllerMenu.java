package com.example.negociogeneral.Controller;

import com.example.entidades.Ingrediente;
import com.example.entidades.IngredientePlato;
import com.example.entidades.Menu;
import com.example.entidades.Plato;
import com.example.negociogeneral.Payload.Request.IngredienteRequest;
import com.example.negociogeneral.Payload.Request.NuevoMenuRequest;
import com.example.negociogeneral.Payload.Request.NuevoPlatoRequest;
import com.example.negociogeneral.Payload.Response.MenuResponse;
import com.example.negociogeneral.Payload.Response.PlatoResponse;
import com.example.negociogeneral.Services.intf.IServicioIngrediente;
import com.example.negociogeneral.Services.intf.IServicioMenu;
import com.example.negociogeneral.Services.intf.IServicioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/general/menus")
public class ControllerMenu {

    @Autowired
    @Qualifier("servicioMenu")
    private IServicioMenu servicioMenu;
    @Autowired
    @Qualifier("servicioPlato")
    IServicioPlato servicioPlato;

    @Autowired
    @Qualifier("servicioIngrediente")
    IServicioIngrediente servicioIngrediente;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity <?> crearMenu(@RequestBody NuevoMenuRequest nuevoMenu){
        try {
            Menu menuTemp = Menu.builder()
                    .nombre(nuevoMenu.getNombre())
                    .build();
            Menu menu = servicioMenu.agregarMenu(menuTemp);

            for (NuevoPlatoRequest plato: nuevoMenu.getPlatos()) {
                Plato platoTemp = Plato.builder()
                        .nombre(plato.getNombre())
                        .precio(plato.getPrecio())
                        .descripcion(plato.getDescripcion())
                        .img(plato.getImagen())
                        .menu(menu)
                        .build();
                Plato p = servicioPlato.agregarPlato(platoTemp);

                for (IngredienteRequest ingrediente: plato.getIngredientes()) {
                    Ingrediente ingredienteTemp = servicioIngrediente.obtenerIngrediente(ingrediente.getIngredienteId());
                    IngredientePlato ingredientePlato = IngredientePlato.builder()
                            .ingrediente(ingredienteTemp)
                            .plato(p)
                            .cantidad(ingrediente.getCantidad())
                            .build();
                    servicioPlato.agregarIngredienteAPlato(ingredientePlato);
                }
            }
            return ResponseEntity.ok("Menu creado correctamente");
        } catch (NamingException | IOException e) {
            return ResponseEntity.badRequest().body("Error al crear el menu");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity <?> listarMenus(){
        List<MenuResponse> menusResponse = new ArrayList<>();

        try {
            List<Menu> menus = servicioMenu.obtenerTodosMenus();
            for (Menu menu: menus) {
                List<Plato> platos = servicioPlato.obtenerTodosPlatosPorMenu(menu);
                List<PlatoResponse> platoResponses = new ArrayList<>();
                for (Plato plato: platos) {
                    PlatoResponse platoTemp = PlatoResponse.builder()
                            .id(plato.getId())
                            .nombre(plato.getNombre())
                            .precio(plato.getPrecio())
                            .imagen(plato.getImg())
                            .descripcion(plato.getDescripcion())
                            .build();
                    platoResponses.add(platoTemp);
                }
                MenuResponse menuTemp = MenuResponse.builder()
                        .id(menu.getId())
                        .nombre(menu.getNombre())
                        .platos(platoResponses)
                        .build();
                menusResponse.add(menuTemp);
            }
            return ResponseEntity.ok().body(menusResponse);
        } catch (NamingException | IOException e) {
            return ResponseEntity.badRequest().body("Error al listar menus");
        }
    }

/*    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/menu={id}")
    public ResponseEntity <?> eliminarMenu(@PathVariable Long id){
        try {
            servicioMenu.eliminarMenu(id);
            return ResponseEntity.ok("Menu eliminado correctamente");
        } catch (NamingException | IOException e) {
            return ResponseEntity.badRequest().body("Error al eliminar el menu");
        }
    }*/



}
