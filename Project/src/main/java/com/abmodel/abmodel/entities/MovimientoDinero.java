package com.abmodel.abmodel.entities;

import java.time.LocalDate;

public class MovimientoDinero {

    private long id;
    private String concepto;
    private float monto;
    private Empleado empleado;
    private LocalDate fechaCreacion;
    private LocalDate fechaActualización;
    public MovimientoDinero(long id, String concepto, float monto, Empleado empleado) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.fechaCreacion = LocalDate.now();
        this.fechaActualización = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaActualización() {
        return fechaActualización;
    }

    public void setFechaActualización(LocalDate fechaActualización) {
        this.fechaActualización = fechaActualización;
    }
}
