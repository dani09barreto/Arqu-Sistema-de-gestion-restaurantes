package com.example.negociogeneral.Services.intf;

import com.example.entidades.Menu;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioMenu {
    void agregarMenu(Menu menu) throws NamingException, IOException;
    void actualizarMenu(Menu menu) throws NamingException, IOException;
    void eliminarMenu(Long id) throws NamingException, IOException;
    Menu obtenerMenu(Long id) throws NamingException, IOException;
    List<Menu> obtenerTodosMenus() throws NamingException, IOException;
}
