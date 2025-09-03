package com.empleados.repository;

import com.empleados.modelo.Departamento;
import com.empleados.repositorio.DepartamentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DepartamentoRepositoryTest {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    void cuandoGuardarDepartamento_entoncesSeGeneraId() {
        Departamento d = new Departamento();
        d.setNombre("Marketing");
        d.setDescripcion("Departamento de marketing digital");

        Departamento guardado = departamentoRepository.save(d);

        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getNombre()).isEqualTo("Marketing");
    }
}
