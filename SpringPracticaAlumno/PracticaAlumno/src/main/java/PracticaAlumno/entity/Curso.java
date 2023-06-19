package PracticaAlumno.entity;



import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Getter@Setter
@Entity
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombreCurso;

    @ManyToMany
    @JoinTable(
            name = "alumno_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_dni")
    )
    @JsonIgnore
    private List<Alumno> listAlumnos;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public List<Alumno> listadoAlumnosDescreciente(){
        return listAlumnos.stream().sorted(Comparator.comparing(Alumno::getApellido).reversed()).collect(Collectors.toList());
    }

    public Double alumnosPromedioEdad(){
        return listAlumnos
                .stream()
                .mapToInt(Alumno::getEdad)
                .average()
                .orElse(0);
    }

    public List<Alumno> alumnosAdeudanMaterias(){
        return listAlumnos.stream().filter(Alumno::getAdeudaMaterias).collect(Collectors.toList());
    }

    public List<Alumno> faltaAbonarMatricula(){
        return listAlumnos
                .stream()
                .filter(entry -> entry.getPagoMatricula())
                .collect(Collectors.toList());
    }

    public void agregarAlumno(Alumno alumno) {
        Boolean alumnoInscripto = listAlumnos.stream().anyMatch(a -> a.getDni().equals(alumno.getDni()));
        if (!alumnoInscripto){
            listAlumnos.add(alumno);
        }else{
            throw new ExceptionAlumnoYaAgregado();
        }
    }

    public void eliminarAlumno(Integer dni) {
        boolean alumnoExistente = listAlumnos.removeIf(a -> a.getDni().equals(dni));
        if (!alumnoExistente) {
            throw new ExceptionAlumnoNoMatriculado();
        }
    }

}
