package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "ComentarioRestaurante")
public class ComentarioRestaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Usuarioid")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Restauranteid")
    private Restaurante restaurante;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private float calificacion;

    @Column(nullable = false)
    private Date fecha;
}

