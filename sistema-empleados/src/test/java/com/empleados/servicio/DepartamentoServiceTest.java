package com.empleados.servicio;

import com.empleados.modelo.Departamento;
import com.empleados.repositorio.DepartamentoRepository;
import com.empleados.servicio.DepartamentoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DepartamentoServiceTest {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    void guardarYBuscarDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNombre("Recursos Humanos");
        departamento.setDescripcion("Gestión del personal");

        departamentoService.guardar(departamento);

        Departamento encontrado = departamentoService.buscarPorId(departamento.getId());
        assertThat(encontrado.getNombre()).isEqualTo("Recursos Humanos");
    }
}
