package PracticaAlumno.exceptions;

import PracticaAlumno.rest.ErrorCodes;
import lombok.Getter;

public class ExceptionAlumnoNoMatriculado extends CustomException {

    public ExceptionAlumnoNoMatriculado() {
        super("El alumno ingresado no se encuentra matriculado en este curso",ErrorCodes.ALUMNO_NO_MATRICULADO);
    }
}
