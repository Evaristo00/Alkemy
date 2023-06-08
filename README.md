# Proyecto de Gestión de Cursos y Alumnos

Este proyecto consiste en un sistema de gestión de cursos y alumnos desarrollado en Java. Permite realizar diversas operaciones como agregar alumnos, asignar calificaciones, obtener información sobre los alumnos y realizar modificaciones en los datos de los alumnos.

## Clase `Alumno`

La clase `Alumno` representa a un estudiante y tiene los siguientes atributos:

- `nombre`: nombre del alumno.
- `apellido`: apellido del alumno.
- `edad`: edad del alumno.
- `adeudaMaterias`: indica si el alumno adeuda materias de la secundaria.
- `pagoMatricula`: indica si el alumno ha pagado la matrícula del curso.

Además, la clase `Alumno` proporciona los siguientes métodos:

- `toString()`: devuelve una representación en cadena del alumno.
- Métodos getter y setter para acceder y modificar los atributos del alumno.

## Clase `Curso`

La clase `Curso` representa un curso y contiene los siguientes atributos:

- `nombreCurso`: nombre del curso.
- `alumnos`: un mapa que mantiene una relación entre cada alumno y su calificación en el curso.

La clase `Curso` proporciona los siguientes métodos:

- `listadoAlumnosDescreciente()`: devuelve una lista de alumnos ordenados alfabéticamente de forma descendente.
- `alumnosPromedioEdad()`: calcula y devuelve el promedio de edad de los alumnos del curso.
- `alumnosAdeudanMaterias()`: devuelve una lista de alumnos que adeudan materias de la secundaria.
- `faltaAbonarMatricula()`: verifica si algún alumno no ha abonado la matrícula del curso.
- `calificacionMasAlta()`: encuentra y devuelve al alumno con la calificación más alta en el curso.
- `agregarAlumno(alumno)`: agrega un nuevo alumno al curso, lanzando una excepción si el alumno ya está matriculado.
- `eliminarAlumno(alumno)`: elimina a un alumno del curso, lanzando una excepción si el alumno no está matriculado.
- `setCalificacion(alumno, calificacion)`: asigna una calificación a un alumno del curso, lanzando una excepción si el alumno no está matriculado.

## Clase `Main`

La clase `Main` contiene el punto de entrada del programa y presenta un menú interactivo para realizar diversas operaciones en el sistema. Permite mostrar el listado de alumnos, obtener el promedio de edad, informar los alumnos que adeudan materias, encontrar al alumno con la nota más alta, verificar si algún alumno no ha abonado la matrícula, agregar un nuevo alumno, dar de baja a un alumno y modificar los datos de un alumno existente.

El programa utiliza listas de cursos y alumnos, y se interactúa con el usuario a través de la consola.

Para ejecutar el programa, simplemente compílalo y ejecuta el método `main` en la clase `Main`.

## Instrucciones

1. Compila el proyecto.
2. Ejecuta el programa.
3. Se mostrará un menú con varias opciones. Ingresa el número correspondiente a la opción deseada y presiona Enter.
4. Sigue las indicaciones en pantalla para realizar las operaciones seleccionadas.
5. Para finalizar el programa, selecciona la opción "0. Salir".

¡Disfruta usando el sistema de gestión de cursos y alumnos!
