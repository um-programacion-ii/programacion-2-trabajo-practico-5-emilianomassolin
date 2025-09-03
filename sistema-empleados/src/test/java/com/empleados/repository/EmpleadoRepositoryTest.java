package com.empleados.repository;

import com.empleados.modelo.Empleado;
import com.empleados.repositorio.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("dev") // Usa H2
class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Test
    void cuandoGuardarEmpleado_entoncesSeGeneraId() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Test");
        empleado.setApellido("User");
        empleado.setEmail("test@empresa.com");
        empleado.setSalario(new BigDecimal("35000"));

        Empleado guardado = empleadoRepository.save(empleado);

        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getEmail()).isEqualTo("test@empresa.com");
    }
}
