package com.empleados.servicio;

import com.empleados.modelo.Proyecto;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoService {
    Proyecto guardar(Proyecto proyecto);
    Proyecto buscarPorId(Long id);
    List<Proyecto> obtenerTodos();
    List<Proyecto> buscarProyectosActivos(LocalDate fechaHoy);
    Proyecto actualizar(Long id, Proyecto proyecto);
    void eliminar(Long id);
}
