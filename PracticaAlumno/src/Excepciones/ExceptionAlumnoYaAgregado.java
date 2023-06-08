package Excepciones;

public class ExceptionAlumnoYaAgregado extends Exception {

    public ExceptionAlumnoYaAgregado() {
        super("El Alumno ya existe en este curso");
    }

}
