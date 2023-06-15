package PracticaAlumno.exceptions;

import PracticaAlumno.rest.ErrorCodes;
import lombok.Getter;

public class ExceptionAlumnoYaCreado extends CustomException {

    public ExceptionAlumnoYaCreado() {
        super("El Alumno ya existe en la base de datos",ErrorCodes.ALUMNO_YA_CREADO);
    }

}
