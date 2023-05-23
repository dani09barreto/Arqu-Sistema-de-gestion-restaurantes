package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "cantidadingrediente")
public class CantidadIngrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Ingredienteid")
    private Ingrediente ingrediente;

    @ManyToOne
    @JoinColumn(name = "EnvioInventarioid")
    private EnvioInventario envioInventario;

    @Column(name = "cantidad")
    private int cantidad;
}

