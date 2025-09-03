package com.empleados.controller;

import com.empleados.controlador.EmpleadoController;
import com.empleados.modelo.Empleado;
import com.empleados.servicio.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpleadoControllerTest {

    @Mock
    private EmpleadoService empleadoService;

    @InjectMocks
    private EmpleadoController empleadoController;

    @Test
    void cuandoGetEmpleados_entoncesDevuelveLista() {
        Empleado e = new Empleado();
        e.setId(1L);
        e.setNombre("Pedro");
        e.setApellido("López");
        e.setEmail("pedro@empresa.com");
        e.setSalario(new BigDecimal("38000"));

        when(empleadoService.obtenerTodos()).thenReturn(List.of(e));

        List<Empleado> resultado = empleadoController.obtenerTodos();

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Pedro");
    }
}
