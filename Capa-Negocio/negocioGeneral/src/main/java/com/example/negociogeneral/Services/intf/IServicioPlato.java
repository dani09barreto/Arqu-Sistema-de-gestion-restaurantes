package com.example.negociogeneral.Services.intf;

import com.example.entidades.IngredientePlato;
import com.example.entidades.Menu;
import com.example.entidades.Plato;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioPlato {
    Plato agregarPlato(Plato plato,  String uri) throws NamingException, IOException;
    void actualizarPlato(Plato plato,  String uri);
    void eliminarPlato(Long id,  String uri);
    Plato obtenerPlato(Long id,  String uri) throws NamingException, IOException;
    List<Plato> obtenerTodosPlatosPorMenu(Menu menu,  String uri) throws NamingException, IOException;
    void agregarIngredienteAPlato(IngredientePlato ingredientePlato,  String uri) throws NamingException, IOException;

    List <IngredientePlato> obtenerIngredientesPorPlato(Long idPlato,  String uri) throws NamingException, IOException;
}
