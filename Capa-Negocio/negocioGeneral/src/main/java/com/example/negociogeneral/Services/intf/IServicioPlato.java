package com.example.negociogeneral.Services.intf;

import com.example.entidades.Menu;
import com.example.entidades.Plato;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioPlato {
    void agregarPlato(Plato plato);
    void actualizarPlato(Plato plato);
    void eliminarPlato(Long id);
    Plato obtenerPlato(Long id);
    List<Plato> obtenerTodosPlatosPorMenu(Menu menu) throws NamingException, IOException;
}
