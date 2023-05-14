package com.example.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RegistroPago")
public class RegistroPago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "fecha",nullable = false,unique = true)
    private Date fecha;
    @ManyToOne
    @Column(name = "Pagoid",nullable = false,unique = true)
    private Pago Pagoid;

}
