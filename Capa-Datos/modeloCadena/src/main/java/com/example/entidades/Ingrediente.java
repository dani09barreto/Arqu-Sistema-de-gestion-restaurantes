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
@Table(name="ingrediente")
public class Ingrediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TipoIngredienteid", nullable = false)
    private TipoIngrediente tipoIngrediente;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
}
