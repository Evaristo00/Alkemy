package PracticaAlumno.controller;

import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import PracticaAlumno.service.ServiceCurso;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Curso obtenerCursoPorId(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.obtenerCursoPorId(id);
    }

    @PostMapping
    public void agregarCurso(@RequestBody CursoDTO cursoDTO) {
        serviceCurso.agregarCurso(cursoDTO);
    }

    @PutMapping("/{id}")
    public void modificarCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) throws ExceptionCursoNoEncontrado {
        serviceCurso.modificarCurso(id, cursoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarCursoPorId(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        serviceCurso.eliminarCursoPorId(id);
    }

    // Otros endpoints para los métodos adicionales del servicio

    @GetMapping("/{id}/alumnos-descreciente")
    public List<Alumno> obtenerListadoAlumnosDescreciente(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.listadoAlumnosDescreciente(id);
    }

    @GetMapping("/{id}/promedio-edad")
    public Double obtenerPromedioEdadAlumnos(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.alumnosPromedioEdad(id);
    }

    @GetMapping("/{id}/alumnos-adeudan-materias")
    public List<Alumno> obtenerAlumnosAdeudanMaterias(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.alumnosAdeudanMaterias(id);
    }

    @GetMapping("/{id}/falta-abonar-matricula")
    public List<Alumno> obtenerAlumnosFaltaAbonarMatricula(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.faltaAbonarMatricula(id);
    }

    @GetMapping("/{id}/calificacion-mas-alta")
    public List<Alumno> obtenerAlumnosCalificacionMasAlta(@PathVariable Integer id) throws ExceptionCursoNoEncontrado {
        return serviceCurso.calificacionMasAlta(id);
    }

    @PostMapping("/{idCurso}/agregar-alumno")
    public void agregarAlumno(@PathVariable Integer idCurso, @RequestBody Alumno alumno) throws ExceptionCursoNoEncontrado, ExceptionAlumnoYaAgregado {
        serviceCurso.agregarAlumno(idCurso, alumno);
    }

    @DeleteMapping("/{idCurso}/{dni}")
    public void eliminarAlumno(@PathVariable Integer idCurso,@PathVariable Integer dni) throws ExceptionCursoNoEncontrado, ExceptionAlumnoNoMatriculado {
        serviceCurso.eliminarAlumno(idCurso, dni);
    }
}
