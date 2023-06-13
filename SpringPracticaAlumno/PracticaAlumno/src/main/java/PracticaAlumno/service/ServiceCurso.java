package PracticaAlumno.service;

import PracticaAlumno.dto.CursoDTO;
import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import PracticaAlumno.exceptions.ExceptionAlumnoNoEncontrado;
import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import PracticaAlumno.exceptions.ExceptionCursoNoEncontrado;
import PracticaAlumno.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCurso {

    List<Curso> cursos = new ArrayList<>();
    private Integer id = 0;

    @Autowired
    private CursoRepository cursoRepository;

//    @Autowired
//    private AlumnoCursoRepository alumnoCursoRepository;
    @Autowired
    private ServiceAlumno serviceAlumno;



    public List<Curso> obtenerTodosLosCursos() {
        List<Curso> listCursos =  cursoRepository.findAll();
        return listCursos;
    }

    public Curso obtenerCursoPorId(Integer id) throws ExceptionCursoNoEncontrado {
        return cursoRepository.findById(id).orElseThrow(() -> new ExceptionCursoNoEncontrado());
    }

    public Curso agregarCurso(CursoDTO cursoDTO) {

        Curso curso = new Curso(cursoDTO.getNombreCurso());
        cursoRepository.save(curso);
        return curso;
    }

    public Curso modificarCurso(Integer id, CursoDTO cursoDTO) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        cursoExistente.setNombreCurso(cursoDTO.getNombreCurso());
        cursoRepository.save(cursoExistente);
        return cursoExistente;
    }

    public Curso eliminarCursoPorId(Integer id) throws ExceptionCursoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(id);
        cursoRepository.delete(cursoExistente);
        return cursoExistente;
    }

    public Alumno agregarAlumno(Integer idCurso, Integer dni) throws ExceptionCursoNoEncontrado, ExceptionAlumnoYaAgregado, ExceptionAlumnoNoEncontrado {
        Curso cursoExistente = obtenerCursoPorId(idCurso);
        Alumno alumnoExistente = serviceAlumno.obtenerAlumnoPorDni(dni);
        cursoExistente.agregarAlumno(alumnoExistente);
        cursoExistente.setNombreCurso("esto se guarda");
        cursoRepository.save(cursoExistente);
        return alumnoExistente;
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

    public void eliminarAlumno(Integer idCurso,Integer dni) throws ExceptionCursoNoEncontrado, ExceptionAlumnoNoMatriculado {
        Curso cursoExistente = obtenerCursoPorId(idCurso);
        cursoExistente.eliminarAlumno(dni);
    }
}
