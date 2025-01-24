package com.TuPlataCrece.MVP.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(String dni) {
        super("Empleado no encontrado con DNI: " + dni);
    }
}
