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
@Table(name = "Mesa")
public class Mesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero",nullable = false,unique = true)
    private String numero;
    @Column(name = "capacidad",nullable = false)
    private long capacidad;
    @Column(name = "ocupada",nullable = false)
    private Boolean ocupada;

}
