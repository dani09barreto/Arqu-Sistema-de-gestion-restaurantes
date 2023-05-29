package com.example.negociogeneral.Services.intf;

import com.example.entidades.Menu;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioMenu {
    Menu agregarMenu(Menu menu, String uri) throws NamingException, IOException;
    void actualizarMenu(Menu menu, String uri) throws NamingException, IOException;
    void eliminarMenu(Long id, String uri) throws NamingException, IOException;
    Menu obtenerMenu(Long id, String uri) throws NamingException, IOException;
    List<Menu> obtenerTodosMenus(String uri) throws NamingException, IOException;
}
