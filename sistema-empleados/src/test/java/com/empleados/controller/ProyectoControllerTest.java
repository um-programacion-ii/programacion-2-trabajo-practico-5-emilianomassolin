package com.empleados.controller;

import com.empleados.controlador.ProyectoController;
import com.empleados.modelo.Proyecto;
import com.empleados.servicio.ProyectoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProyectoControllerTest {

    @Mock
    private ProyectoService proyectoService;

    @InjectMocks
    private ProyectoController proyectoController;

    @Test
    void cuandoGetProyectos_entoncesDevuelveLista() {
        Proyecto p = new Proyecto();
        p.setId(1L);
        p.setNombre("Sistema RRHH");
        p.setDescripcion("Proyecto de gestión de recursos humanos");
        p.setFechaInicio(LocalDate.now());
        p.setFechaFin(LocalDate.now().plusMonths(3));

        when(proyectoService.obtenerTodos()).thenReturn(List.of(p));

        List<Proyecto> resultado = proyectoController.obtenerTodos();

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Sistema RRHH");
    }
}
