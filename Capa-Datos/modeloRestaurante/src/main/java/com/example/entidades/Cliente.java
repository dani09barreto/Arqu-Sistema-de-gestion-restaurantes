package com.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;
    @Column(name = "email", unique = true, nullable = false)
    private String email;



}
