package PracticaAlumno.exceptions;

public class ExceptionAlumnoYaCreado extends Exception {

    public ExceptionAlumnoYaCreado() {
        super("El Alumno ya existe en este curso");
    }

}
