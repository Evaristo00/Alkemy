package PracticaAlumno.controller;

import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import PracticaAlumno.service.ServiceCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/curso")
public class contollerCurso {
    @Autowired
    private ServiceCurso serviceCurso;

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {

        return serviceCurso.obtenerTodosLosCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCursoPorId(@PathVariable Integer id) {
        try {
            Curso curso = serviceCurso.obtenerCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body("Curso no encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(serviceCurso.agregarCurso(cursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> modificarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
        try {
            Curso curso = serviceCurso.modificarCurso(id, cursoDTO);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> eliminarCursoPorId(@PathVariable Integer id) {
        try {
            Curso curso = serviceCurso.eliminarCursoPorId(id);
            return ResponseEntity.ok(curso);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Otros endpoints para los métodos adicionales del servicio

    @GetMapping("/{id}/alumnos-descreciente")
    public ResponseEntity<?> obtenerListadoAlumnosDescreciente(@PathVariable Integer id) {
        try {
            List<Alumno> alumnos = serviceCurso.listadoAlumnosDescreciente(id);
            return ResponseEntity.ok(alumnos);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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

    @GetMapping("/{id}/calificacion-mas-alta")
    public ResponseEntity<?> obtenerAlumnosCalificacionMasAlta(@PathVariable Integer id) {
        try {
            List<Alumno> alumnos = serviceCurso.calificacionMasAlta(id);
            return ResponseEntity.ok(alumnos);
        } catch (ExceptionCursoNoEncontrado e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{idCurso}/agregar-alumno")
    public ResponseEntity<Alumno> agregarAlumno(@PathVariable Integer idCurso, @RequestBody Alumno alumno) {
        try {
            Alumno alumnoAgregado = serviceCurso.agregarAlumno(idCurso, alumno);
            return ResponseEntity.ok(alumnoAgregado);
        } catch (ExceptionCursoNoEncontrado | ExceptionAlumnoYaAgregado e) {
            return ResponseEntity.badRequest().body(null);
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
