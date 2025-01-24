package com.TuPlataCrece.MVP.dtos;


public class Response {
    private String dni;
    private boolean prestamoDisponible;
    private boolean empleadoEncontrado;
    private boolean empleadoInvalido;
    private Double importe;
    private String mensaje;

    public Response(){}

    public Response(String dni, boolean prestamoDisponible, boolean empleadoEncontrado, Double importe) {
        this.dni = dni;
        this.prestamoDisponible = prestamoDisponible;
        this.empleadoEncontrado = empleadoEncontrado;
        this.empleadoInvalido = false;
        this.importe = importe;
        if (prestamoDisponible) {
            this.mensaje = "Se puede solicitar un prestamo por el importe: " + this.importe;
        } else if (empleadoEncontrado) {
            this.mensaje = "Empleado con DNI: " + this.dni + " no tiene credito disponible.";
        }
    }

    public Response(boolean empleadoInvalido, String dni){
        this.empleadoInvalido = empleadoInvalido;
        this.prestamoDisponible = false;
        this.empleadoEncontrado = false;
        this.mensaje = "Empleado no encontrado con DNI: " + dni;
    }

    public boolean tienePrestamo(){
        return this.prestamoDisponible;
    }

    public boolean empleadoEncontrado(){
        return this.empleadoEncontrado;
    }

    public boolean empleadoInvalido(){
        return this.empleadoInvalido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isPrestamoDisponible() {
        return prestamoDisponible;
    }

    public void setPrestamoDisponible(boolean prestamoDisponible) {
        this.prestamoDisponible = prestamoDisponible;
    }

    public boolean isEmpleadoEncontrado() {
        return empleadoEncontrado;
    }

    public void setEmpleadoEncontrado(boolean empleadoEncontrado) {
        this.empleadoEncontrado = empleadoEncontrado;
    }

    public boolean isEmpleadoInvalido() {
        return empleadoInvalido;
    }

    public void setEmpleadoInvalido(boolean empleadoInvalido) {
        this.empleadoInvalido = empleadoInvalido;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
