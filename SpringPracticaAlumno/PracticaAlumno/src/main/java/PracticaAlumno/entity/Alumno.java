package PracticaAlumno.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Alumno {

    private Integer dni;
    private String nombre;

    private String apellido;

    private Integer edad;

    private Boolean adeudaMaterias;

    private Boolean pagoMatricula;

    @Override
    public String toString() {
        return this.nombre + ", " + this.apellido + "\t - " + this.edad + "años.";
    }

}
