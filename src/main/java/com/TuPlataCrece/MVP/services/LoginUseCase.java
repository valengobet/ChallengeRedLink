package com.TuPlataCrece.MVP.services;

import com.TuPlataCrece.MVP.dtos.Response;
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

    public Response login(String dni){
        var empleado = empleadoRepository.findByDni(dni);
        if(empleado.isEmpty()){
            return new Response(true, dni);
        }

        if(empleado.get().getImporte() == null){
            empleado.get().setImportevisto(LocalDate.now());
            empleadoRepository.save(empleado.get());
            return new Response(empleado.get().getDni(), false, true, null);
        }

        empleado.get().setImportevisto(LocalDate.now());
        empleadoRepository.save(empleado.get());
        return new Response(empleado.get().getDni(), true, true, empleado.get().getImporte());
    }
}
