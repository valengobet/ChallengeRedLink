package com.TuPlataCrece.MVP.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String dni;
    private Double importe;
    private LocalDate visualizado;

    public Empleado() {};

    public Empleado(String dni, Double importe){
        this.dni = dni;
        this.importe = importe;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public LocalDate getVisualizado() {
        return visualizado;
    }

    public void setImportevisto(LocalDate visualizado) {
        this.visualizado = visualizado;
    }
}
