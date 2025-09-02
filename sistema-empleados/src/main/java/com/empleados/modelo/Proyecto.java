package com.empleados.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyectos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del proyecto no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    private String descripcion;

    @FutureOrPresent(message = "La fecha de inicio no puede ser anterior a hoy")
    private LocalDate fechaInicio;

    @FutureOrPresent(message = "La fecha de fin no puede ser anterior a hoy")
    private LocalDate fechaFin;

    @ManyToMany(mappedBy = "proyectos")
    private Set<Empleado> empleados = new HashSet<>();
}
