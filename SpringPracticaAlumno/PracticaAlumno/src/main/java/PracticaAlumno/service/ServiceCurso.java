package PracticaAlumno.service;

import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCurso {

    List<Curso> cursos = new ArrayList<>();
    private Integer id = 0;

    @Autowired
    private ServiceAlumno serviceAlumno;

    @PostConstruct
    public void init() {
        Curso cursoIngreso = new Curso(id++,"Curso de Ingreso");
        Curso cursoProgramacion = new Curso(id++,"Programación");
        Curso cursoReact = new Curso(id++,"React");

        //todos los alumnos al curso de ingreso
        serviceAlumno.obtenerTodosLosAlumnos().stream().forEach(alumno -> {
            try {
                cursoIngreso.agregarAlumno(alumno);
            } catch (ExceptionAlumnoYaAgregado e) {
                throw new RuntimeException(e);
            }
        });
        try {
            cursoProgramacion.agregarAlumno(serviceAlumno.obtenerAlumnoPorDni(23456789));
            cursoProgramacion.agregarAlumno(serviceAlumno.obtenerAlumnoPorDni(34567890));
            cursoReact.agregarAlumno(serviceAlumno.obtenerAlumnoPorDni(45678901));
            cursoReact.agregarAlumno(serviceAlumno.obtenerAlumnoPorDni(56789012));
        } catch (ExceptionAlumnoYaAgregado e) {
            System.out.println(e.getMessage());
        } catch (ExceptionAlumnoNoEncontrado e) {
            System.out.println(e.getMessage());
        }

        //registrar notas
        try {
            cursoIngreso.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(12345678),9);
            cursoIngreso.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(23456789),9);
            cursoIngreso.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(34567890),7);
            cursoIngreso.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(45678901),8);
            cursoIngreso.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(56789012),6);
            cursoProgramacion.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(23456789),9);
            cursoProgramacion.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(34567890),7);
            cursoReact.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(45678901),8);
            cursoReact.setCalificacion(serviceAlumno.obtenerAlumnoPorDni(56789012),6);
        } catch (ExceptionAlumnoNoMatriculado e) {
            throw new RuntimeException(e);
        } catch (ExceptionAlumnoNoEncontrado e) {
            throw new RuntimeException(e);
        }



        cursos.add(cursoIngreso);
        cursos.add(cursoProgramacion);
        cursos.add(cursoReact);


    }



    public List<Curso> obtenerTodosLosCursos() {
        return cursos;
    }

    public Curso obtenerCursoPorId(Integer id) throws ExceptionCursoNoEncontrado {
        Optional<Curso> curso = cursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return curso.orElseThrow(() -> new ExceptionCursoNoEncontrado());
    }

    public Curso agregarCurso(CursoDTO cursoDTO) {

        Curso curso = new Curso(id++,cursoDTO.getNombreCurso());
        cursos.add(curso);
        return curso;
    }

    public Curso modificarCurso(Integer id, CursoDTO cursoDTO) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        cursoExistente.setNombreCurso(cursoDTO.getNombreCurso());
        return cursoExistente;
    }

    public Curso eliminarCursoPorId(Integer id) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        cursos.remove(cursoExistente);
        return cursoExistente;
    }

    // Otros métodos para cada método definido en la clase Curso
    public List<Alumno> listadoAlumnosDescreciente(Integer id) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        return cursoExistente.listadoAlumnosDescreciente();
    }

    public Double alumnosPromedioEdad(Integer id) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        return cursoExistente.alumnosPromedioEdad();
    }

    public List<Alumno> alumnosAdeudanMaterias(Integer id) throws ExceptionCursoNoEncontrado{
        Curso cursoExistente = obtenerCursoPorId(id);
        return cursoExistente.alumnosAdeudanMaterias();
    }

    public List<Alumno> faltaAbonarMatricula(Integer id) throws  ExceptionCursoNoEncontrado{
        Curso cursoExistente = obtenerCursoPorId(id);
        return cursoExistente.faltaAbonarMatricula();
    }

    public List<Alumno> calificacionMasAlta(Integer id) throws  ExceptionCursoNoEncontrado{
        Curso cursoExistente = obtenerCursoPorId(id);
        return cursoExistente.calificacionMasAlta();
    }

    public Alumno agregarAlumno(Integer idCurso, Alumno alumno) throws ExceptionCursoNoEncontrado, ExceptionAlumnoYaAgregado {
        Curso cursoExistente = obtenerCursoPorId(idCurso);
        cursoExistente.agregarAlumno(alumno);
        return alumno;
    }

    public void eliminarAlumno(Integer idCurso,Integer dni) throws ExceptionCursoNoEncontrado, ExceptionAlumnoNoMatriculado {
        Curso cursoExistente = obtenerCursoPorId(idCurso);
        cursoExistente.eliminarAlumno(dni);
    }
}
