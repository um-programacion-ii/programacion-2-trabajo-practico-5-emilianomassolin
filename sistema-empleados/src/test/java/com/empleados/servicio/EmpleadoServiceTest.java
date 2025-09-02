package com.empleados.servicio;

import com.empleados.modelo.Empleado;
import com.empleados.repositorio.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmpleadoServiceTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Test
    void guardarYBuscarEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Pérez");
        empleado.setEmail("juan@test.com");
        empleado.setSalario(new BigDecimal("5000"));
        empleado.setFechaContratacion(LocalDate.now());

        Empleado guardado = empleadoService.guardar(empleado);

        Empleado encontrado = empleadoService.buscarPorId(guardado.getId());

        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getEmail()).isEqualTo("juan@test.com");
    }
}
