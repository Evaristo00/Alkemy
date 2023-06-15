package PracticaAlumno.exceptions;

import PracticaAlumno.rest.ErrorCodes;
import lombok.Getter;

public class ExceptionCursoNoEncontrado extends CustomException {


    public ExceptionCursoNoEncontrado() {
        super("Curso no encontrado",ErrorCodes.CURSO_NO_ENCONTRADO);
    }
}