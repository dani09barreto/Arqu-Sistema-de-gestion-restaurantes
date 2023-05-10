package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Bodegaid")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "Ingredienteid")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private int cantidad;
}
