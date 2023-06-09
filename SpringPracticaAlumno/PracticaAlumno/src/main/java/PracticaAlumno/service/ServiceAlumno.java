package PracticaAlumno.service;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaCreado;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAlumno {

    List<Alumno> alumnos = new ArrayList<>();


    @PostConstruct
    public void init() {
        Alumno alumno1 = new Alumno(12345678, "Juan", "Pérez", 20, false, false);
        Alumno alumno2 = new Alumno(23456789, "María", "Gómez", 22, true, true);
        Alumno alumno3 = new Alumno(34567890, "Pedro", "López", 19, false, false);
        Alumno alumno4 = new Alumno(45678901, "Laura", "García", 21, true, true);
        Alumno alumno5 = new Alumno(56789012, "Carlos", "Martínez", 18, true, true);
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        alumnos.add(alumno5);
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnos;
    }

    public Alumno obtenerAlumnoPorDni(Integer dni)  throws ExceptionAlumnoNoEncontrado {
        Optional<Alumno> alumno = alumnos.stream()
                .filter(a -> a.getDni().equals(dni))
                .findFirst();

        return alumno.orElseThrow(() -> new ExceptionAlumnoNoEncontrado());
    }

    public Alumno agregarAlumno(Alumno alumno) throws ExceptionAlumnoYaCreado {
        Boolean existeAlumno = alumnos.stream()
                .anyMatch(a -> a.getDni().equals(alumno.getDni()));
        if (existeAlumno) throw new ExceptionAlumnoYaCreado();
        alumnos.add(alumno);
        return alumno;
    }

    public Alumno actualizarAlumno(Alumno alumnoActualizado) throws ExceptionAlumnoNoEncontrado {
        Alumno alumnoExistente = obtenerAlumnoPorDni(alumnoActualizado.getDni());
        int index = alumnos.indexOf(alumnoExistente);
        alumnos.set(index, alumnoActualizado);
        return alumnoActualizado;
    }

    public Alumno eliminarAlumnoPorDni(Integer dni) throws ExceptionAlumnoNoEncontrado {
        Alumno alumnoExistente = obtenerAlumnoPorDni(dni);
        alumnos.remove(alumnoExistente);
        return alumnoExistente;
    }
}
