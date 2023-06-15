package PracticaAlumno.rest;

import PracticaAlumno.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler({ExceptionAlumnoNoEncontrado.class,
                        ExceptionAlumnoYaAgregado.class,
                        ExceptionAlumnoYaCreado.class,
                        ExceptionAlumnoNoMatriculado.class,
                        ExceptionCursoNoEncontrado.class
                        })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<String>> handlerCustomExcetions(CustomException ex) {
        Response<String> response = new Response<>();
        response.addError(ex.getErrorCode());
        response.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}