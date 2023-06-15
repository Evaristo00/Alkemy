package PracticaAlumno.exceptions;

import PracticaAlumno.rest.ErrorCodes;
import lombok.Getter;

public class ExceptionAlumnoYaAgregado extends CustomException {
    public ExceptionAlumnoYaAgregado() {
        super("El Alumno ya existe en este curso",ErrorCodes.ALUMNO_YA_AGREGADO);
    }

}
