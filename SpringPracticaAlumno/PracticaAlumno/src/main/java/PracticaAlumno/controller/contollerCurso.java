package PracticaAlumno.controller;

import PracticaAlumno.dto.AlumnoDTO;
import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import PracticaAlumno.service.ServiceCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/cursos")
public class contollerCurso {
    @Autowired
    private ServiceCurso serviceCurso;

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosCursos() {
        List<Curso> cursoList = serviceCurso.obtenerTodosLosCursos();
        return ResponseEntity.ok(cursoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCursoPorId(@PathVariable Integer id) {
        try {
            Curso curso = serviceCurso.obtenerCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso cursoAgregado = serviceCurso.agregarCurso(cursoDTO);
        return ResponseEntity.created(URI.create("/cursos/" + cursoAgregado.getId())).body(cursoAgregado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
        try {
            Curso curso = serviceCurso.modificarCurso(id, cursoDTO);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCursoPorId(@PathVariable Integer id) {
        try {
            Curso curso = serviceCurso.eliminarCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Otros endpoints para los métodos adicionales del servicio

    @GetMapping("/{id}/alumnos-descreciente")
    public ResponseEntity<?> obtenerListadoAlumnosDescreciente(@PathVariable Integer id) {
        try {
            List<Alumno> alumnos = serviceCurso.listadoAlumnosDescreciente(id);
            return ResponseEntity.ok(alumnos);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/promedio-edad")
    public ResponseEntity<?> obtenerPromedioEdadAlumnos(@PathVariable Integer id) {
        try {
            Double promedioEdad = serviceCurso.alumnosPromedioEdad(id);
            return ResponseEntity.ok(promedioEdad);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/alumnos-adeudan-materias")
    public ResponseEntity<?> obtenerAlumnosAdeudanMaterias(@PathVariable Integer id) {
        try {
            List<Alumno> alumnos = serviceCurso.alumnosAdeudanMaterias(id);
            return ResponseEntity.ok(alumnos);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/falta-abonar-matricula")
    public ResponseEntity<?> obtenerAlumnosFaltaAbonarMatricula(@PathVariable Integer id) {
        try {
            List<Alumno> alumnos = serviceCurso.faltaAbonarMatricula(id);
            return ResponseEntity.ok(alumnos);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{idCurso}/agregar-alumno")
    public ResponseEntity<?> agregarAlumno(@PathVariable Integer idCurso, @RequestBody AlumnoDTO alumnoDTO) {
        try {
            Alumno alumnoAgregado = serviceCurso.agregarAlumno(idCurso, alumnoDTO.getDni());
            return ResponseEntity.created(null).body(alumnoAgregado);
        } catch (ExceptionCursoNoEncontrado | ExceptionAlumnoYaAgregado | ExceptionAlumnoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{idCurso}/{dni}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable Integer idCurso, @PathVariable Integer dni) {
        try {
            serviceCurso.eliminarAlumno(idCurso, dni);
            return ResponseEntity.ok("Alumno eliminado correctamente");
        } catch (ExceptionCursoNoEncontrado | ExceptionAlumnoNoMatriculado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
