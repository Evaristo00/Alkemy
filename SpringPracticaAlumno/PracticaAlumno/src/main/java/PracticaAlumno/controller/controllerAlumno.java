package PracticaAlumno.controller;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaCreado;
import PracticaAlumno.service.ServiceAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> obtenerAlumnoPorDni(@PathVariable Integer dni) {
        try {
            Alumno alumno = serviceAlumno.obtenerAlumnoPorDni(dni);
            return ResponseEntity.ok(alumno);
        } catch (ExceptionAlumnoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarAlumno(@RequestBody Alumno alumno) {
        try {
            return ResponseEntity.ok(serviceAlumno.agregarAlumno(alumno));
        } catch (ExceptionAlumnoYaCreado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> actualizarAlumno(@RequestBody Alumno alumno) {
        try {
            return ResponseEntity.ok(serviceAlumno.actualizarAlumno(alumno));
        } catch (ExceptionAlumnoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> eliminarAlumnoPorDni(@PathVariable Integer dni) {
        try {
            return ResponseEntity.ok(serviceAlumno.eliminarAlumnoPorDni(dni));
        } catch (ExceptionAlumnoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
