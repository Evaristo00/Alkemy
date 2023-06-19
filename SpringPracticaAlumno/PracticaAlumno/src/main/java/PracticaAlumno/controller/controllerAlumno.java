package PracticaAlumno.controller;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.rest.Response;
import PracticaAlumno.service.ServiceAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class controllerAlumno {

    @Autowired
    private  ServiceAlumno serviceAlumno;

    @GetMapping
    public ResponseEntity<Response<List<Alumno>>> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos = serviceAlumno.obtenerTodosLosAlumnos();
        Response<List<Alumno>> response = new Response<>();
        response.setData(alumnos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Response<Alumno>> obtenerAlumnoPorDni(@PathVariable Integer dni) {
            Alumno alumno = serviceAlumno.obtenerAlumnoPorDni(dni);
            Response<Alumno> response = new Response<>();
            response.setData(alumno);
            return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<Alumno>> agregarAlumno(@RequestBody Alumno alumno) {
            Alumno alumnoAgrgado = serviceAlumno.agregarAlumno(alumno);
            Response<Alumno> response = new Response<>();
            response.setData(alumnoAgrgado);
            return ResponseEntity.created(URI.create("/alumnos/" + alumnoAgrgado.getDni())).body(response);
    }

    @PutMapping()
    public ResponseEntity<Response<Alumno>> actualizarAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoAcualizado = serviceAlumno.actualizarAlumno(alumno);
        Response<Alumno> response = new Response<>();
        response.setData(alumnoAcualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> eliminarAlumnoPorDni(@PathVariable Integer dni) {
        serviceAlumno.eliminarAlumnoPorDni(dni);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/busqueda")
    public ResponseEntity<Response<?>> obtenerAlumno(@RequestParam(required = false) Optional<Integer> dni){
        Response<Object> response = new Response<>();
        if (dni.isPresent()){
            response.setData(serviceAlumno.obtenerAlumnoPorDni(dni.get()));
        }else{
            response.setData(serviceAlumno.obtenerTodosLosAlumnos());
        }
        return ResponseEntity.ok().body(response);
    }
}
