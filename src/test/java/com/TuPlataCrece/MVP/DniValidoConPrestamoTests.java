package com.TuPlataCrece.MVP;

import com.TuPlataCrece.MVP.controllers.PrestamosController;
import com.TuPlataCrece.MVP.models.Empleado;
import com.TuPlataCrece.MVP.models.EmpleadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class DniValidoConPrestamoTests {
    @Autowired
    private PrestamosController controller;
    @Autowired
    private EmpleadoRepository repository;
    private String dni;
    private Double importe;

    @BeforeEach
    void setup() {
        var empleado = repository.save(new Empleado("1", 1000.0));
        this.dni = empleado.getDni();
        this.importe = empleado.getImporte();
    }

    @Test
    void ok() {
        ResponseEntity<String> response = controller.login(dni);
        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(200));
        Assertions.assertEquals(response.getBody(), "Se puede solicitar un prestamo por el importe: " + importe);
    }
}
