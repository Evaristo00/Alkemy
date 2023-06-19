package PracticaAlumno.controller;

import PracticaAlumno.dto.AlumnoDTO;
import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import PracticaAlumno.rest.Response;
import PracticaAlumno.service.ServiceCurso;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class contollerCurso {

    private final ServiceCurso serviceCurso;

    @GetMapping
    public ResponseEntity<Response<List<Curso>>> obtenerTodosLosCursos() {
        Response<List<Curso>> response = new Response<>();
        List<Curso> cursoList = serviceCurso.obtenerTodosLosCursos();
        response.setData(cursoList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Curso>> obtenerCursoPorId(@PathVariable Integer id) {
        Response<Curso> response = new Response<>();
        Curso curso = serviceCurso.obtenerCursoPorId(id);
        response.setData(curso);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<Curso>> agregarCurso(@Valid @RequestBody CursoDTO cursoDTO) {
        Response<Curso> response = new Response<>();
        Curso cursoAgregado = serviceCurso.agregarCurso(cursoDTO);
        response.setData(cursoAgregado);
        return ResponseEntity.created(URI.create("/cursos/" + cursoAgregado.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Curso>> modificarCurso(@PathVariable Integer id, @Valid@RequestBody CursoDTO cursoDTO) {
        Response<Curso> response = new Response<>();
        Curso curso = serviceCurso.modificarCurso(id, cursoDTO);
        response.setData(curso);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCursoPorId(@PathVariable Integer id) {
            serviceCurso.eliminarCursoPorId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Otros endpoints para los métodos adicionales del servicio

    @GetMapping("/{id}/alumnos-descreciente")
    public ResponseEntity<Response<List<Alumno>>> obtenerListadoAlumnosDescreciente(@PathVariable Integer id) {
        Response<List<Alumno>> response = new Response<>();
        List<Alumno> alumnos = serviceCurso.listadoAlumnosDescreciente(id);
        response.setData(alumnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/promedio-edad")
    public ResponseEntity<Response<Double>> obtenerPromedioEdadAlumnos(@PathVariable Integer id) {
        Response<Double> response = new Response<>();
        Double promedioEdad = serviceCurso.alumnosPromedioEdad(id);
        response.setData(promedioEdad);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/alumnos-adeudan-materias")
    public ResponseEntity<Response<List<Alumno>>> obtenerAlumnosAdeudanMaterias(@PathVariable Integer id) {
        Response<List<Alumno>> response = new Response<>();
        List<Alumno> alumnos = serviceCurso.alumnosAdeudanMaterias(id);
        response.setData(alumnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/falta-abonar-matricula")
    public ResponseEntity<Response<List<Alumno>>> obtenerAlumnosFaltaAbonarMatricula(@PathVariable Integer id) {
        Response<List<Alumno>> response = new Response<>();
        List<Alumno> alumnos = serviceCurso.faltaAbonarMatricula(id);
        response.setData(alumnos);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{idCurso}/agregar-alumno")
    public ResponseEntity<Response<Alumno>> agregarAlumno(@PathVariable Integer idCurso, @RequestBody AlumnoDTO alumnoDTO) {
        Response<Alumno> response = new Response<>();
        Alumno alumnoAgregado = serviceCurso.agregarAlumno(idCurso, alumnoDTO.dni());
        response.setData(alumnoAgregado);
        return ResponseEntity.created(null).body(response);
    }


    @DeleteMapping("/{idCurso}/{dni}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer idCurso, @PathVariable Integer dni) {
         serviceCurso.eliminarAlumno(idCurso, dni);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
