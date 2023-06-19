package PracticaAlumno.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SingUpRequestDTO(Integer dni,@NotBlank String mail,@NotBlank String password, String nombre,
                               String apellido, Integer edad, Boolean adeudaMaterias,
                               Boolean pagoMatricula) {
    public SingUpRequestDTO() {
        this(null,"", "", "", "", 0, false, false);
    }
}

