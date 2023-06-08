import Excepciones.ExceptionAlumnoNoMatriculado;
import Excepciones.ExceptionAlumnoYaAgregado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<>();
        List<Alumno> alumnos = new ArrayList<>();

        Curso cursoIngreso = new Curso("Curso de Ingreso");
        Curso cursoProgramacion = new Curso("Programación");
        Curso cursoReact = new Curso("React");

        cursos.add(cursoIngreso);
        cursos.add(cursoProgramacion);
        cursos.add(cursoReact);

        Alumno alumno1 = new Alumno("Juan", "Pérez", 20, false,false);
        Alumno alumno2 = new Alumno("María", "Gómez", 22, true,true);
        Alumno alumno3 = new Alumno("Pedro", "López", 19, false,false);
        Alumno alumno4 = new Alumno("Laura", "García", 21, true,true);
        Alumno alumno5 = new Alumno("Carlos", "Martínez", 18, true,true);

        alumnos.addAll(List.of(alumno1,alumno2,alumno3,alumno4,alumno5));

        try {
            cursoIngreso.agregarAlumno(alumno1);
            cursoIngreso.agregarAlumno(alumno2);
            cursoIngreso.agregarAlumno(alumno3);
            cursoIngreso.agregarAlumno(alumno4);
            cursoIngreso.agregarAlumno(alumno5);
            cursoProgramacion.agregarAlumno(alumno2);
            cursoProgramacion.agregarAlumno(alumno3);
            cursoReact.agregarAlumno(alumno4);
            cursoReact.agregarAlumno(alumno5);
        } catch (ExceptionAlumnoYaAgregado e) {
            System.out.println(e.getMessage());
        }

        try {
            cursoIngreso.setCalificacion(alumno1, 9);
            cursoIngreso.setCalificacion(alumno2, 9);
            cursoIngreso.setCalificacion(alumno3, 7);
            cursoIngreso.setCalificacion(alumno4, 8);
            cursoIngreso.setCalificacion(alumno5, 6);
            cursoProgramacion.setCalificacion(alumno2, 9);
            cursoProgramacion.setCalificacion(alumno3, 7);
            cursoReact.setCalificacion(alumno4, 8);
            cursoReact.setCalificacion(alumno5, 6);
        } catch (ExceptionAlumnoNoMatriculado e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            menu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer la opción
            ejecutarOpcion(opcion,alumnos,cursos,salir,scanner);
            System.out.println(); // Agregar una línea en blanco después de cada opción del menú
        }

        scanner.close();
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    private static Boolean ejecutarOpcion(int opcion, List<Alumno> alumnos,List<Curso> cursos,Boolean salir, Scanner scanner) {
        switch (opcion) {
            case 1:
                System.out.println("Mostrar listado de alumnos:");
                List<Alumno> listaAlumnos = obtenerCurso(scanner,cursos).listadoAlumnosDescreciente();
                printList(listaAlumnos);

                break;
            case 2:
                System.out.println("Obtener promedio de edad de los alumnos:");
                Double promedio = obtenerCurso(scanner,cursos).alumnosPromedioEdad();
                System.out.println("El promedio de edad de los alumnos es de:" + promedio);
                break;
            case 3:
                System.out.println("Informar alumnos que adeudan materias de la secundaria:");
                List<Alumno> listAdeudanMaterias = obtenerCurso(scanner,cursos).alumnosAdeudanMaterias();
                printList(listAdeudanMaterias);
                break;
            case 4:
                System.out.println("Encontrar alumno con la nota más alta en el curso de ingreso:");
                List<Alumno> alumnosMaxCalificaion = cursos.get(0).calificacionMasAlta();
                printList(alumnosMaxCalificaion);
                break;
            case 5:
                System.out.println("Informar si algún alumno no abonó la matrícula del curso:");
                Boolean faltaAbonar = obtenerCurso(scanner,cursos).faltaAbonarMatricula();
                if (faltaAbonar) {
                    System.out.println("No todos abonaron la matricula");
                } else {
                    System.out.println("Todos abonaron la matricula");
                }
                break;
            case 6:
                System.out.println("Agregar un nuevo alumno al curso:");
                Curso cursoAgregado = obtenerCurso(scanner,cursos);
                Alumno alumnoParaAgregar = obtenerAlumno(scanner,alumnos);
                try {
                    cursoAgregado.agregarAlumno(alumnoParaAgregar);
                    System.out.println("El alumno fue añadido con exito");
                }catch (ExceptionAlumnoYaAgregado e){
                    System.out.println(e.getMessage());
                }
                break;
            case 7:
                System.out.println("Dar de baja a un alumno:");
                Curso cursoParaDisminuir = obtenerCurso(scanner,cursos);
                Alumno alumnoParaEliminar = obtenerAlumno(scanner,alumnos);
                try {
                    cursoParaDisminuir.eliminarAlumno(alumnoParaEliminar);
                    System.out.println("El alumno fue eliminado con exito");
                }catch (ExceptionAlumnoNoMatriculado e){
                    System.out.println(e.getMessage());
                }
                break;
            case 8:
                System.out.println("Modificar los datos de un alumno:");
                Alumno alumnoModificar = obtenerAlumno(scanner,alumnos);
                seleccionarModificaciones(alumnoModificar,scanner);
                break;
            case 0:
                salir = true;
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                break;
        }
        return salir;
    }

    private static void seleccionarModificaciones(Alumno alumno, Scanner scanner) {
        String aux;
        System.out.println("Si no se desea modificar el atributo, oprimir ENTER y pasar al siguiente.");

        System.out.print("Nuevo nombre: ");
        aux = scanner.nextLine();
        if (!aux.isEmpty()) {
            alumno.setNombre(aux);
        }

        System.out.print("Nuevo apellido: ");
        aux = scanner.nextLine();
        if (!aux.isEmpty()) {
            alumno.setApellido(aux);
        }

        System.out.print("Nueva edad: ");
        aux = scanner.nextLine();
        if (!aux.isEmpty()) {
            try {
                int edad = Integer.parseInt(aux);
                alumno.setEdad(edad);
            } catch (NumberFormatException e) {
                System.out.println("Error: La edad debe ser un número entero.");
            }
        }
        if(alumno.getAdeudaMaterias())
            System.out.println("actualmente el alumno no adeuda materias");
        else
            System.out.println("actualmente el alumno no adeuda materias");
        System.out.print("¿Adeuda materias? (Sí/No): ");
        aux = scanner.nextLine();
        if (!aux.isEmpty()) {
            boolean adeudaMaterias = aux.equalsIgnoreCase("Sí") || aux.equalsIgnoreCase("Si");
            alumno.setAdeudaMaterias(adeudaMaterias);
        }
        if(alumno.getPagoMatricula())
            System.out.println("actualmente el alumno tiene paga la matricula");
        else
            System.out.println("actualmente el alumno no tiene paga la matricula");
        System.out.print("¿Pagó la matrícula? (Sí/No): ");
        aux = scanner.nextLine();
        if (!aux.isEmpty()) {
            boolean pagoMatricula = aux.equalsIgnoreCase("Sí") || aux.equalsIgnoreCase("Si");
            alumno.setPagoMatricula(pagoMatricula);
        }
    }


    public static void menu (){
        System.out.println("----- MENÚ -----");
        System.out.println("\t1. Mostrar el listado de alumnos ordenados alfabéticamente");
        System.out.println("\t2. Obtener el promedio de edad de todos los alumnos");
        System.out.println("\t3. Informar los alumnos que adeudan materias de la secundaria");
        System.out.println("\t4. Encontrar el alumno con la nota más alta en el curso de ingreso");
        System.out.println("\t5. Informar si algún alumno no abonó la matrícula del curso");
        System.out.println("\t6. Agregar un nuevo alumno al curso");
        System.out.println("\t7. Dar de baja a un alumno");
        System.out.println("\t8. Modificar los datos de un alumno");
        System.out.println("\t0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void printListaCursos(List<Curso> cursos){
        System.out.println("Elegir el curso del cual mostrar listado:");
        System.out.println("Cursos:");
        IntStream.range(0, cursos.size())
                .forEach(i -> System.out.printf("\t%d. %s\n", i, cursos.get(i).getNombreCurso()));
    }

    public static Curso obtenerCurso(Scanner scanner,List<Curso> cursos){
        printListaCursos(cursos);
        int numCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la opción
        return cursos.get(numCurso);
    }

    public static void printListaAlumnos(List<Alumno> alumnos){
        System.out.println("Elegir el alumno:");
        System.out.println("Alumnos:");
        IntStream.range(0, alumnos.size())
                .forEach(i -> System.out.printf("\t%d. %s\n", i, alumnos.get(i).toString()));
    }

    public static Alumno obtenerAlumno(Scanner scanner,List<Alumno> alumnos){
        printListaAlumnos(alumnos);
        int numCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la opción
        return alumnos.get(numCurso);
    }
}