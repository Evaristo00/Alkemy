package PracticaAlumno.repository;

import PracticaAlumno.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findAll();
    Optional<Alumno> findByDni(Integer dni);

    Optional<Alumno> findByMail(String mail);
}

