package com.abmodel.abmodel.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String concepto;
    private float monto;
    @ManyToOne
    @JoinColumn(name = "transaccion_empleado")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "transaccion_empresa")
    private Empresa empresa;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}