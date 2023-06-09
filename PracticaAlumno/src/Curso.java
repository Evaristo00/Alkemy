import Excepciones.ExceptionAlumnoNoMatriculado;
import Excepciones.ExceptionAlumnoYaAgregado;

import java.util.*;
import java.util.stream.Collectors;


public class Curso {

    private String nombreCurso;

    private Map<Alumno,Integer> alumnos;

    public Curso(String nombreCurso, HashMap<Alumno,Integer> alumnos) {
        this.nombreCurso = nombreCurso;
        this.alumnos = alumnos;
    }

    public Curso(String nombreCurso) {
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
        if (!alumnos.containsKey(alumno)){
            alumnos.put(alumno,null);
        }else{
            throw new ExceptionAlumnoYaAgregado();
        }
    }

    public void eliminarAlumno(Alumno alumno) throws ExceptionAlumnoNoMatriculado {
        if(alumnos.containsKey(alumno))
            alumnos.remove(alumno);
        else
            throw new ExceptionAlumnoNoMatriculado();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setCalificacion(Alumno alumno,int calificacion) throws ExceptionAlumnoNoMatriculado {
        if(alumnos.containsKey(alumno))
            alumnos.put(alumno,calificacion);
        else
            throw new ExceptionAlumnoNoMatriculado();
    }

}
