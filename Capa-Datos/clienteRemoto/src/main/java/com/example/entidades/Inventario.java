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
@Table(name="inventario")
public class Inventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Bodegaid")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "Ingredienteid")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private int cantidad;
}
