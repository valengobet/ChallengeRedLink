package com.TuPlataCrece.MVP;

import com.TuPlataCrece.MVP.controllers.PrestamosController;
import com.TuPlataCrece.MVP.dtos.Response;
import com.TuPlataCrece.MVP.models.Empleado;
import com.TuPlataCrece.MVP.models.EmpleadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class ListaVisualizacionesTests {
    @Autowired
    private PrestamosController controller;
    @Autowired
    private EmpleadoRepository repository;

    @BeforeEach
    void setup() {
        var empleado1 = repository.save(new Empleado("1", 1000.0));
        var empleado2 = repository.save(new Empleado("2", 500.0));
        var empleado3 = repository.save(new Empleado("3", null));
        controller.login(empleado1.getDni());
        controller.login(empleado2.getDni());
    }

    @Test
    void ok() {
        List<String> visualizaciones = controller.auditViewsToday();
        Assertions.assertEquals(visualizaciones.size(), 2);
        Assertions.assertEquals(visualizaciones.contains("1"), true);
        Assertions.assertEquals(visualizaciones.contains("2"), true);
        Assertions.assertEquals(visualizaciones.contains("3"), false);
    }
}
