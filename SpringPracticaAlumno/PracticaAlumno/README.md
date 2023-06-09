# API de Alumnos y Cursos

Esta API permite gestionar alumnos y cursos, así como realizar diversas operaciones relacionadas con ellos.

## Tabla de contenidos

- [Modelo de datos](#modelo-de-datos)
- [Endpoints](#endpoints)

## Modelo de datos

El modelo de datos de la API incluye las siguientes entidades:

### Alumno

Clase que representa a un alumno.

Atributos:
- `dni` (Integer): DNI del alumno.
- `nombre` (String): Nombre del alumno.
- `apellido` (String): Apellido del alumno.
- `edad` (Integer): Edad del alumno.
- `adeudaMaterias` (Boolean): Indica si el alumno adeuda materias.
- `pagoMatricula` (Boolean): Indica si el alumno ha pagado la matrícula.

### Curso

Clase que representa un curso.

Atributos:
- `id` (Integer): Identificador del curso.
- `nombreCurso` (String): Nombre del curso.
- `alumnos` (Map<Alumno, Integer>): Mapa que asocia cada alumno con una calificación.

## Endpoints

A continuación se detallan los endpoints disponibles en la API.

### Alumno

- `GET /alumno`: Obtiene todos los alumnos registrados.
- `GET /alumno/{dni}`: Obtiene un alumno por su DNI.
- `POST /alumno`: Agrega un nuevo alumno.
- `PUT /alumno`: Actualiza los datos de un alumno.
- `DELETE /alumno/{dni}`: Elimina un alumno por su DNI.

### Curso

- `GET /curso`: Obtiene todos los cursos registrados.
- `GET /curso/{id}`: Obtiene un curso por su ID.
- `POST /curso`: Agrega un nuevo curso.
- `PUT /curso/{id}`: Modifica los datos de un curso.
- `DELETE /curso/{id}`: Elimina un curso por su ID.
- `GET /curso/{id}/alumnos-descreciente`: Obtiene el listado de alumnos de un curso en orden descendente por apellido.
- `GET /curso/{id}/promedio-edad`: Calcula el promedio de edad de los alumnos de un curso.
- `GET /curso/{id}/alumnos-adeudan-materias`: Obtiene la lista de alumnos de un curso que adeudan materias.
- `GET /curso/{id}/falta-abonar-matricula`: Obtiene la lista de alumnos de un curso que no han abonado la matrícula.
- `GET /curso/{id}/calificacion-mas-alta`: Obtiene la lista de alumnos de un curso con la calificación más alta.
- `POST /curso/{idCurso}/agregar-alumno`: Agrega un alumno a un curso.
- `DELETE /curso/{idCurso}/{dni}`: Elimina un alumno de un curso por su DNI.

**Nota:** Los parámetros entre llaves `{}` indican que se deben reemplazar con un valor válido al hacer la petición.

### Swagger

- `GET /docs/swagger-ui.html`: Accede a Swagger UI para explorar la documentación interactiva de la API.

**Nota:** Los parámetros entre llaves `{}` indican que se deben reemplazar con un valor válido al hacer la petición.