package PracticaAlumno.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public record AlumnoDTO(@NotNull @Size(min = 8, max = 8) Integer dni) {}