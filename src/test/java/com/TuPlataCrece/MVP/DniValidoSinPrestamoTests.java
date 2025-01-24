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
class DniValidoSinPrestamoTests {
    @Autowired
    private PrestamosController controller;
    @Autowired
    private EmpleadoRepository repository;
    private String dni;

    @BeforeEach
    void setup() {
        var empleado = repository.save(new Empleado("1", null));
        this.dni = empleado.getDni();
    }

    @Test
    void ok() {
        ResponseEntity<String> response = controller.login(dni);
        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(400));
        Assertions.assertEquals(response.getBody(), "Empleado con DNI: " + dni + " no tiene credito disponible.");
    }
}
