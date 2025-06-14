
package com.uisrael.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_simulacion")
@NoArgsConstructor
@AllArgsConstructor
public class Simulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String cedula;
    private String email;
    private String celular;

    private double capitalInicial;
    private int numeroPeriodos;
    private int tiempoAnios;

    private double tasaInteres;
    private double montoFinal;
    private double interesGanado;

    private String categoria;
    private LocalDateTime fechaSimulacion;
}