package PracticaAlumno.repository;

import PracticaAlumno.entity.Alumno;
import PracticaAlumno.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Integer> {

    List<Curso> findAll();
}
