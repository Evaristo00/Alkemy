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
- `cursos` (List<Curso>): Lista de cursos en los que está inscrito el alumno.

### Curso

Clase que representa un curso.

Atributos:
- `id` (Integer): Identificador del curso.
- `nombreCurso` (String): Nombre del curso.
- `listAlumnos` (List<Alumno>): Lista de alumnos inscritos en el curso.

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
- `POST /curso/{idCurso}/agregar-alumno`: Agrega un alumno a un curso.
- `DELETE /curso/{idCurso}/{dni}`: Elimina un alumno de un curso por su DNI.

**Nota:** Los parámetros entre llaves `{}` indican que se deben reemplazar con un valor válido al hacer la petición.

### Swagger

- `GET /docs/swagger-ui.html`: Accede a Swagger UI para explorar la documentación interactiva de la API.

**Nota:** Los parámetros entre llaves `{}` indican que se deben reemplazar con un valor válido al hacer la petición.


## Base de datos

La API utiliza una base de datos MySQL para almacenar los datos de alumnos y cursos. La conexión a la base de datos se realiza utilizando Hibernate y JPA.

Para utilizar el contenedor Docker en la base de datos de la API, se proporciona un archivo `docker-compose.yml` en la carpeta `Docker`. Este archivo define los servicios necesarios para ejecutar la base de datos MySQL dentro de un contenedor.

El uso de Docker permite crear un entorno aislado y portátil que contiene todos los componentes necesarios para ejecutar la base de datos sin afectar el entorno local de tu máquina.

A continuación, se explica cómo utilizar el contenedor Docker para ejecutar la base de datos:

1. Abre una terminal o línea de comandos.
2. Navega hasta la carpeta `Docker` del proyecto de la API. Puedes usar el comando `cd` seguido de la ruta de la carpeta.
3. Una vez dentro de la carpeta `Docker`, ejecuta el siguiente comando:

   ```
   docker-compose up
   ```

   Este comando leerá el archivo `docker-compose.yml` y construirá el contenedor de la base de datos MySQL junto con cualquier configuración adicional especificada en el archivo.

4. Docker descargará la imagen de MySQL si no está presente en tu máquina y luego iniciará el contenedor de la base de datos.
5. Una vez que el contenedor esté en funcionamiento, podrás conectarte a la base de datos MySQL utilizando la configuración proporcionada en la API.

Ten en cuenta que es posible que necesites tener Docker instalado en tu máquina antes de poder ejecutar el comando `docker-compose`. Además, asegúrate de tener los permisos necesarios para ejecutar Docker.

Al seguir estos pasos, el contenedor Docker con la base de datos estará en funcionamiento y podrás utilizarlo con la API de Alumnos y Cursos.

Si deseas utilizar XAMPP en lugar de Docker para la base de datos, debes realizar los siguientes pasos:

1. Abre el archivo `application.properties` ubicado en la raíz del proyecto de la API.
2. Comenta las configuraciones relacionadas con Docker, para ello, añade un símbolo de numeral (#) al inicio de cada línea correspondiente a Docker. Deberás comentar las siguientes líneas:

   ```
   # Descomentar para utilizar docker
   # spring.jpa.hibernate.ddl-auto=update
   # spring.datasource.url=jdbc:mysql://localhost:3306/ALKEMYDB
   # spring.datasource.username=root
   # spring.datasource.password=password

   # jpa.hibernate.ddl-auto= update
   # properties.hibernate.dialect= org.hibernate.dialect.MySQLDialect
   # spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

3. Descomenta las configuraciones relacionadas con XAMPP, eliminando el símbolo de numeral (#) al inicio de cada línea correspondiente a XAMPP. Deberás descomentar las siguientes líneas:

   ```
   # Configuaracion para utilizar XAMPP
   spring.datasource.url=jdbc:mysql://localhost:3306/alkemydb
   spring.datasource.username=root
   spring.datasource.password=
   spring.datasource.driver-class-name=com.mysql.jdbc.Driver

   # Configuración de Hibernate
   spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update
   ```

Al realizar estos cambios en el archivo `application.properties`, estarás configurando la API para utilizar XAMPP en lugar del contenedor Docker. Asegúrate de tener XAMPP instalado y en funcionamiento en tu máquina antes de ejecutar la API.

Recuerda que si optas por utilizar XAMPP, deberás tener la base de datos MySQL configurada y en ejecución a través de XAMPP para que la API pueda establecer conexión correctamente.