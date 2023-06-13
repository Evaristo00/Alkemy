package PracticaAlumno.service;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaCreado;
import PracticaAlumno.repository.AlumnoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAlumno {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerAlumnoPorDni(Integer dni)  throws ExceptionAlumnoNoEncontrado {
        return alumnoRepository.findByDni(dni)
                .orElseThrow(() -> new ExceptionAlumnoNoEncontrado());
    }

    public Alumno agregarAlumno(Alumno alumno) throws ExceptionAlumnoYaCreado {
//        Boolean existeAlumno = alumnos.stream()
//                .anyMatch(a -> a.getDni().equals(alumno.getDni()));

        Boolean existeAlumno = alumnoRepository.findByDni(alumno.getDni()).isPresent();
        if (existeAlumno) throw new ExceptionAlumnoYaCreado();
        alumnoRepository.save(alumno);
        return alumno;
    }

    public Alumno actualizarAlumno(Alumno alumnoActualizado) throws ExceptionAlumnoNoEncontrado {
        Alumno alumnoExistente = obtenerAlumnoPorDni(alumnoActualizado.getDni());
        alumnoRepository.save(alumnoActualizado);
        return alumnoActualizado;
    }

    public Alumno eliminarAlumnoPorDni(Integer dni) throws ExceptionAlumnoNoEncontrado {
        Alumno alumnoExistente = obtenerAlumnoPorDni(dni);
        alumnoRepository.delete(alumnoExistente);
        return alumnoExistente;
    }
}
