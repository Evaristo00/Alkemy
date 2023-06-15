package PracticaAlumno.exceptions;

import PracticaAlumno.rest.ErrorCodes;
import lombok.Getter;

public class ExceptionAlumnoNoEncontrado extends CustomException {
    public ExceptionAlumnoNoEncontrado() {
        super("Alumno no encontrado", ErrorCodes.ALUMNO_NO_ENCONTRADO);
    }
}
