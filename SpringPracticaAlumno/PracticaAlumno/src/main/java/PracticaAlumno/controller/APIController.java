package PracticaAlumno.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.*;

@RestController
public class APIController {

    List<String> endpoints = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Controlador ControllerCurso
        endpoints.add("GET /curso - Obtener todos los cursos");
        endpoints.add("GET /curso/{id} - Obtener un curso por su ID");
        endpoints.add("POST /curso - Agregar un nuevo curso");
        endpoints.add("PUT /curso/{id} - Modificar un curso existente");
        endpoints.add("DELETE /curso/{id} - Eliminar un curso por su ID");
        endpoints.add("GET /curso/{id}/alumnos-descreciente - Obtener el listado de alumnos de un curso en orden descreciente");
        endpoints.add("GET /curso/{id}/promedio-edad - Obtener el promedio de edad de los alumnos de un curso");
        endpoints.add("GET /curso/{id}/alumnos-adeudan-materias - Obtener los alumnos de un curso que adeudan materias");
        endpoints.add("GET /curso/{id}/falta-abonar-matricula - Obtener los alumnos de un curso que tienen pendiente abonar la matrícula");
        endpoints.add("GET /curso/{id}/calificacion-mas-alta - Obtener los alumnos de un curso con la calificación más alta");
        endpoints.add("POST /curso/{idCurso}/agregar-alumno - Agregar un alumno a un curso por su ID");
        endpoints.add("DELETE /curso/{idCurso}/eliminar-alumno - Eliminar un alumno de un curso por su ID");

        // Controlador ControllerAlumno
        endpoints.add("GET /alumno - Obtener todos los alumnos");
        endpoints.add("GET /alumno/{dni} - Obtener un alumno por su DNI");
        endpoints.add("POST /alumno - Agregar un nuevo alumno");
        endpoints.add("PUT /alumno - Actualizar un alumno existente");
        endpoints.add("DELETE /alumno/{dni} - Eliminar un alumno por su DNI");
    }

    @GetMapping("/endpoints")
    public List<String> obtenerEndpoints() {
        return endpoints;
    }
}