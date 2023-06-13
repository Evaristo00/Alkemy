CREATE DATABASE IF NOT EXISTS ALKEMYDB;

USE ALKEMYDB;

---- Crear tabla alumno
--CREATE TABLE alumno (
--  dni INT PRIMARY KEY,
--  nombre VARCHAR(255) NOT NULL,
--  apellido VARCHAR(255) NOT NULL,
--  edad INT NOT NULL,
--  adeuda_materias BOOLEAN NOT NULL,
--  pago_matricula BOOLEAN NOT NULL
--);
--
---- Crear tabla curso
--CREATE TABLE curso (
--  id INT PRIMARY KEY AUTO_INCREMENT,
--  nombre_curso VARCHAR(255) NOT NULL
--);
--
---- Crear tabla alumno_curso
--CREATE TABLE alumno_Curso (
--  alumno_id INT,
--  curso_id INT,
--  nota DOUBLE,
--  PRIMARY KEY (alumno_id, curso_id),
--  FOREIGN KEY (alumno_id) REFERENCES Alumno(dni),
--  FOREIGN KEY (curso_id) REFERENCES Curso(id)
--);

INSERT INTO alumno (dni, nombre, apellido, edad, adeuda_materias, pago_matricula)
VALUES
    (12345678, 'Juan', 'Pérez', 20, false, false),
    (23456789, 'María', 'Gómez', 22, true, true),
    (34567890, 'Pedro', 'López', 19, false, false),
    (45678901, 'Laura', 'García', 21, true, true),
    (56789012, 'Carlos', 'Martínez', 18, true, true);


INSERT INTO curso (nombre_curso)
VALUES
    ("Curso de Ingreso"),
    ("Programación"),
    ("React");