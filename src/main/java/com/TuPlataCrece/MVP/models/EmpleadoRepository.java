package com.TuPlataCrece.MVP.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByDni(String dni);
    List<Empleado> findByVisualizado(LocalDate visualizado);
}

