package com.example;

import javax.naming.NamingException;

public class clienteRemoto {
    public static void main(String[] args) {
        IServiceLocator serviceLocator = new ServiceLocator();
        try {
            serviceLocator.getRemoteBodegaService().obtenerTodasBodegas().forEach(bodega -> {
                System.out.println(bodega.getNombre());
            });
            serviceLocator.getRemoteIngredientePlatoService().obtenerIngredientesPlato(29L).forEach(ingredientePlato -> {
                System.out.println(ingredientePlato.getPlato().getNombre());
                System.out.println(ingredientePlato.getIngrediente().getNombre());
                System.out.println(ingredientePlato.getIngrediente().getTipoIngrediente().getNombre());
                System.out.println(ingredientePlato.getCantidad());
            });
        } catch (NamingException e) {
            System.out.println(e.getMessage());
        }
    }
}
