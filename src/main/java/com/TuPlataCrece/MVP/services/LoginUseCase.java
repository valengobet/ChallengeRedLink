package com.TuPlataCrece.MVP.services;

import com.TuPlataCrece.MVP.exceptions.EmpleadoNotFoundException;
import com.TuPlataCrece.MVP.exceptions.EmpleadoSinImporteException;
import com.TuPlataCrece.MVP.models.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class LoginUseCase {
    private final EmpleadoRepository empleadoRepository;

    public LoginUseCase(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public String login(String dni){
        var empleado = empleadoRepository.findByDni(dni).orElseThrow(()
                -> new EmpleadoNotFoundException(dni));

        if(empleado.getImporte() == null){
            empleado.setImportevisto(LocalDate.now());
            empleadoRepository.save(empleado);
            throw new EmpleadoSinImporteException(dni);
        }
        empleado.setImportevisto(LocalDate.now());
        empleadoRepository.save(empleado);
        return "Se puede solicitar un prestamo por el importe: " + empleado.getImporte();
    }
}
