package PracticaAlumno.controller;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaCreado;
import PracticaAlumno.service.ServiceAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class controllerAlumno {

    @Autowired
    private  ServiceAlumno serviceAlumno;

    @GetMapping
    public List<Alumno> obtenerTodosLosAlumnos() {
        return serviceAlumno.obtenerTodosLosAlumnos();
    }

    @GetMapping("/{dni}")
    public Alumno obtenerAlumnoPorDni(@PathVariable Integer dni) throws ExceptionAlumnoNoEncontrado {
        return serviceAlumno.obtenerAlumnoPorDni(dni);
    }

    @PostMapping
    public void agregarAlumno(@RequestBody Alumno alumno) throws ExceptionAlumnoYaCreado {
        serviceAlumno.agregarAlumno(alumno);
    }

    @PutMapping()
    public void actualizarAlumno(@RequestBody Alumno alumno) throws ExceptionAlumnoNoEncontrado {
        serviceAlumno.actualizarAlumno(alumno);
    }

    @DeleteMapping("/{dni}")
    public void eliminarAlumnoPorDni(@PathVariable Integer dni) throws ExceptionAlumnoNoEncontrado {
        serviceAlumno.eliminarAlumnoPorDni(dni);
    }
}
