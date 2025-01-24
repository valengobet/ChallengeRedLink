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
class DniInvalidoTests {
    @Autowired
    private PrestamosController controller;
    @Autowired
    private EmpleadoRepository repository;
    private String dni;

    @BeforeEach
    void setup() {
        this.dni = "2";
    }

    @Test
    void ok() {
        ResponseEntity<String> response = controller.login(dni);
        Assertions.assertEquals(response.getStatusCode(), HttpStatusCode.valueOf(404));
        Assertions.assertEquals(response.getBody(), "Empleado no encontrado con DNI: " + dni);
    }
}
