package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="bodega")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "direccion", unique = true, nullable = false)
    private String direccion;

    @Column(name = "lat", unique = true, nullable = false)
    private double lat;

    @Column(name = "lng", unique = true, nullable = false)
    private double lng;
}
