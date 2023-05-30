package com.example.modeloRestaurante.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "RegistroPago")
public class Reserva {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "fechareserva",nullable = false,unique = true)
    private Date fechareserva;
    @ManyToOne
    @JoinColumn(name = "MesaId",nullable = false,unique = true)
    private Mesa Mesaid;
    @ManyToOne
    @JoinColumn(name = "Clienteid",nullable = false,unique = true)
    private Cliente clienteid;
}
