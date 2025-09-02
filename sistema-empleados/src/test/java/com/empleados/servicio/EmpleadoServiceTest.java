package com.empleados.servicio;

import com.empleados.modelo.Departamento;
import com.empleados.modelo.Empleado;
import com.empleados.repositorio.DepartamentoRepository;
import com.empleados.repositorio.EmpleadoRepository;
import com.empleados.servicio.EmpleadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // BD limpia por test
class EmpleadoServiceTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private Departamento departamento;

    @BeforeEach
    void setup() {
        departamento = new Departamento();
        departamento.setNombre("IT");
        departamento.setDescripcion("Departamento de Tecnología");
        departamentoRepository.save(departamento);
    }

    @Test
    void guardarYBuscarEmpleadoPorEmail() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Pérez");
        empleado.setEmail("juan@example.com");
        empleado.setSalario(new BigDecimal("5000"));
        empleado.setFechaContratacion(LocalDate.now());
        empleado.setDepartamento(departamento);

        empleadoService.guardar(empleado);

        Empleado encontrado = empleadoService.buscarPorId(empleado.getId());
        assertThat(encontrado.getEmail()).isEqualTo("juan@example.com");
    }

    @Test
    void buscarPorDepartamento() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Ana");
        empleado.setApellido("García");
        empleado.setEmail("ana@example.com");
        empleado.setSalario(new BigDecimal("6000"));
        empleado.setFechaContratacion(LocalDate.now());
        empleado.setDepartamento(departamento);
        empleadoRepository.save(empleado);

        List<Empleado> lista = empleadoService.buscarPorDepartamento("IT");
        assertThat(lista).hasSize(1);
    }

    @Test
    void buscarPorRangoSalario() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Carlos");
        empleado.setApellido("Lopez");
        empleado.setEmail("carlos@example.com");
        empleado.setSalario(new BigDecimal("7000"));
        empleado.setFechaContratacion(LocalDate.now());
        empleado.setDepartamento(departamento);
        empleadoRepository.save(empleado);

        List<Empleado> lista = empleadoService.buscarPorRangoSalario(new BigDecimal("6000"), new BigDecimal("8000"));
        assertThat(lista).extracting(Empleado::getNombre).contains("Carlos");
    }
}
