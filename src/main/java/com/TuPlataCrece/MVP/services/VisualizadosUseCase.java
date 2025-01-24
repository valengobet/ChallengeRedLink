package com.TuPlataCrece.MVP.services;

import com.TuPlataCrece.MVP.models.Empleado;
import com.TuPlataCrece.MVP.models.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisualizadosUseCase {
    private final EmpleadoRepository empleadoRepository;

    public VisualizadosUseCase(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public List<String> visualizadosHoy(){
        List<Empleado> empleados = empleadoRepository.findByVisualizado(LocalDate.now());
        List<String> response = new ArrayList<>();
        for(Empleado empleado : empleados){
            response.add(empleado.getDni());
        }
        return response;
    }

}
