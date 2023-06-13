package PracticaAlumno.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    private Integer dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private Integer edad;
    @Column(nullable = false)
    private Boolean adeudaMaterias;
    @Column(nullable = false)
    private Boolean pagoMatricula;

//    @OneToMany(mappedBy = "alumno")
//    private Set<InfoAlumnoCurso> informacionCursos;

    @ManyToMany(mappedBy = "listAlumnos")
    private List<Curso> cursos;

    public Alumno(Integer dni, String nombre, String apellido, Integer edad, Boolean adeudaMaterias, Boolean pagoMatricula) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.adeudaMaterias = adeudaMaterias;
        this.pagoMatricula = pagoMatricula;
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.apellido + "\t - " + this.edad + "años.";
    }

}
