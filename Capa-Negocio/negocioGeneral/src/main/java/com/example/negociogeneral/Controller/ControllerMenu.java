package com.example.negociogeneral.Controller;

import com.example.entidades.Menu;
import com.example.entidades.Plato;
import com.example.negociogeneral.Payload.Request.NuevoMenuRequest;
import com.example.negociogeneral.Payload.Response.MenuResponse;
import com.example.negociogeneral.Payload.Response.PlatoResponse;
import com.example.negociogeneral.Services.intf.IServicioMenu;
import com.example.negociogeneral.Services.intf.IServicioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity <?> crearMenu(@RequestBody NuevoMenuRequest nuevoMenu){
        System.out.println(nuevoMenu.getNombre());
        return ResponseEntity.ok().body("Menu creado exitosamente");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
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

    
}
