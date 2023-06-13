//package PracticaAlumno.entity;
//
//import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//
//@Embeddable
//@Getter@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class InfoAlumnoCursoId implements Serializable {
//
//    private Integer alumnoId;
//    private Integer cursoId;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof InfoAlumnoCursoId)) return false;
//        InfoAlumnoCursoId that = (InfoAlumnoCursoId) o;
//        return Objects.equals(getAlumnoId(), that.getAlumnoId()) &&
//                Objects.equals(getCursoId(), that.getCursoId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getAlumnoId(), getCursoId());
//    }
//}
