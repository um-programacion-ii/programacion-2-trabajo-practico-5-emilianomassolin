package com.empleados.servicio;

import com.empleados.modelo.Proyecto;
import com.empleados.repositorio.ProyectoRepository;
import com.empleados.servicio.ProyectoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProyectoServiceTest {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Test
    void guardarYBuscarProyectoActivo() {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre("Nuevo Sistema");
        proyecto.setDescripcion("Implementación del sistema de gestión");
        proyecto.setFechaInicio(LocalDate.now());
        proyecto.setFechaFin(LocalDate.now().plusMonths(6));
        proyectoService.guardar(proyecto);

        List<Proyecto> activos = proyectoService.buscarProyectosActivos(LocalDate.now());
        assertThat(activos).extracting(Proyecto::getNombre).contains("Nuevo Sistema");
    }
}
