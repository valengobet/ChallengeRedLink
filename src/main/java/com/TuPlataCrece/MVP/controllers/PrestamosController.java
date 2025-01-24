package com.TuPlataCrece.MVP.controllers;

import com.TuPlataCrece.MVP.exceptions.EmpleadoNotFoundException;
import com.TuPlataCrece.MVP.exceptions.EmpleadoSinImporteException;
import com.TuPlataCrece.MVP.services.LoginUseCase;
import com.TuPlataCrece.MVP.services.VisualizadosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
    @Autowired
    private LoginUseCase loginUseCase;
    @Autowired
    private VisualizadosUseCase visualizadosUseCase;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String dni) {
        try {
            String response = loginUseCase.login(dni);
            return ResponseEntity.ok(response);
        } catch (EmpleadoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch(EmpleadoSinImporteException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/view")
    public List<String> auditViewsToday(){
        return visualizadosUseCase.visualizadosHoy();
    }
}
