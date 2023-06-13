//package PracticaAlumno.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class InfoAlumnoCurso {
//
//    @EmbeddedId
//    private InfoAlumnoCursoId id;
//    @Column(name = "nota")
//    private double nota;
//
//    // Relación many-to-one con Alumno
//    @ManyToOne
//    @MapsId("alumnoId")
//    @JoinColumn(name = "alumno_id",insertable = false, updatable = false)
//    private Alumno alumno;
//
//    // Relación many-to-one con Curso
//    @ManyToOne
//    @MapsId("cursoId")
//    @JoinColumn(name = "curso_id",insertable = false, updatable = false)
//    private Curso curso;
//
//    public InfoAlumnoCurso(InfoAlumnoCursoId id, Alumno alumno, Curso curso) {
//        this.id = id;
//        this.alumno = alumno;
//        this.curso = curso;
//    }
//}
