package PracticaAlumno.entity;



import PracticaAlumno.exceptions.ExceptionAlumnoNoMatriculado;
import PracticaAlumno.exceptions.ExceptionAlumnoYaAgregado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;

import java.util.*;
import java.util.stream.Collectors;


public class Curso {
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private String nombreCurso;

    private Map<Alumno,Integer> alumnos;

    public Curso(String nombreCurso, HashMap<Alumno,Integer> alumnos) {
        this.nombreCurso = nombreCurso;
        this.alumnos = alumnos;
    }

    public Curso(Integer id,String nombreCurso) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.alumnos = new HashMap<>();
    }

    public List<Alumno> listadoAlumnosDescreciente(){
        return alumnos.keySet().stream().sorted(Comparator.comparing(Alumno::getApellido).reversed()).collect(Collectors.toList());
    }

    public Double alumnosPromedioEdad(){
        return alumnos.keySet()
                .stream()
                .mapToInt(Alumno::getEdad)
                .average()
                .orElse(0);
    }

    public List<Alumno> alumnosAdeudanMaterias(){
        return alumnos.keySet().stream().filter(Alumno::getAdeudaMaterias).collect(Collectors.toList());
    }

    public List<Alumno> faltaAbonarMatricula(){
        return alumnos.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getPagoMatricula())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Alumno> calificacionMasAlta(){
        Optional<Integer> maxCalificacion = alumnos.values().stream().max(Integer::compareTo);
        return maxCalificacion.map(max -> alumnos.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(max))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public void agregarAlumno(Alumno alumno) throws ExceptionAlumnoYaAgregado {
        Boolean alumnoInscripto = alumnos.keySet().stream().anyMatch(a -> a.getDni().equals(alumno.getDni()));
        if (!alumnoInscripto){
            alumnos.put(alumno,null);
        }else{
            throw new ExceptionAlumnoYaAgregado();
        }
    }

    public void eliminarAlumno(Integer dni) throws ExceptionAlumnoNoMatriculado {
        boolean alumnoExistente = alumnos.keySet().removeIf(a -> a.getDni().equals(dni));
        if (!alumnoExistente) {
            throw new ExceptionAlumnoNoMatriculado();
        }
    }



    public void setCalificacion(Alumno alumno,int calificacion) throws ExceptionAlumnoNoMatriculado {
        if(alumnos.containsKey(alumno))
            alumnos.put(alumno,calificacion);
        else
            throw new ExceptionAlumnoNoMatriculado();
    }

}
