package com.example.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "envioinventario")
public class EnvioInventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Restauranteid")
    private Restaurante restaurante;
    @ManyToOne
    @JoinColumn(name = "Usuarioid")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "EstadoEnvioid")
    private EstadoEnvio estadoEnvio;
    @ManyToOne
    @JoinColumn(name = "Bodegaid")
    private Bodega bodega;
    @Column(name = "fecha")
    private Date fecha;
}
