package com.empleados.repository;

import com.empleados.modelo.Proyecto;
import com.empleados.repositorio.ProyectoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProyectoRepositoryTest {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Test
    void cuandoGuardarProyecto_entoncesSeGeneraId() {
        Proyecto p = new Proyecto();
        p.setNombre("App Ventas");
        p.setDescripcion("Proyecto para gestionar ventas online");
        p.setFechaInicio(LocalDate.now());

        Proyecto guardado = proyectoRepository.save(p);

        assertThat(guardado.getId()).isNotNull();
        assertThat(guardado.getNombre()).isEqualTo("App Ventas");
    }
}

