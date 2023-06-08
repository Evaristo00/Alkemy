package Excepciones;

public class ExceptionAlumnoNoMatriculado extends Exception {

    public ExceptionAlumnoNoMatriculado() {
        super("El alumno ingresado no se encuentra matriculado en este curso");
    }
}
