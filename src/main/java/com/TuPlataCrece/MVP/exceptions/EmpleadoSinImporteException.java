package com.TuPlataCrece.MVP.exceptions;

public class EmpleadoSinImporteException extends RuntimeException {
    public EmpleadoSinImporteException(String dni) {
        super("Empleado con DNI: " + dni + " no tiene credito disponible.");
    }
}

