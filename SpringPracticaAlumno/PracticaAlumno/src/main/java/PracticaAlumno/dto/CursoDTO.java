package PracticaAlumno.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
public record CursoDTO(@NotNull @NotBlank String nombreCurso) {}