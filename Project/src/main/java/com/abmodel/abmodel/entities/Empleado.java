package com.abmodel.abmodel.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {

    //Atributos
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fechacreacion")
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private String nombre;
    private String email;
    @ManyToOne
    @JoinColumn(name = "empleado_empresa")
    private Empresa empresa;
    private Enum_RoleName rol;

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", empresa=" + empresa +
                ", rol=" + rol +
                '}';
    }
}
