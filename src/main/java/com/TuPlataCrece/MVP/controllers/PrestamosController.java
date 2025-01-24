package com.TuPlataCrece.MVP.controllers;

import com.TuPlataCrece.MVP.dtos.Response;
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
    public ResponseEntity<Response> login(@RequestParam String dni) {
        Response response = loginUseCase.login(dni);
        if(response.tienePrestamo()) {
            return ResponseEntity.ok(response);
        } else if(response.empleadoInvalido()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/view")
    public List<String> auditViewsToday(){
        return visualizadosUseCase.visualizadosHoy();
    }
}
