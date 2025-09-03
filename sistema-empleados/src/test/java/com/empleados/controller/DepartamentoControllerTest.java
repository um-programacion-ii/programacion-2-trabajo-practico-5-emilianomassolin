package com.empleados.controller;

import com.empleados.controlador.DepartamentoController;
import com.empleados.modelo.Departamento;
import com.empleados.servicio.DepartamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartamentoControllerTest {

    @Mock
    private DepartamentoService departamentoService;

    @InjectMocks
    private DepartamentoController departamentoController;

    @Test
    void cuandoGetDepartamentos_entoncesDevuelveLista() {
        Departamento d = new Departamento();
        d.setId(1L);
        d.setNombre("IT");
        d.setDescripcion("Tecnología");

        when(departamentoService.obtenerTodos()).thenReturn(List.of(d));

        List<Departamento> resultado = departamentoController.obtenerTodos();

        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("IT");
    }
}
