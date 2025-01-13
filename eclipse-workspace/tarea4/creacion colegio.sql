CREATE SCHEMA colegio;
USE colegio;

-- Crear la tabla Profesor primero
CREATE TABLE Profesor (
    IdProfesor INT AUTO_INCREMENT PRIMARY KEY,
    NIF_P VARCHAR(50) UNIQUE,
    Nombre VARCHAR(100),
    Especialidad VARCHAR(100),
    Telefono VARCHAR(20)
);

-- Tabla Alumno
CREATE TABLE Alumno (
    NumMatricula INT PRIMARY KEY,
    Nombre VARCHAR(100),
    FechaNacimiento DATE,
    Telefono VARCHAR(20)
);

-- Crear la tabla Asignatura después de Profesor
CREATE TABLE Asignatura (
    CodAsignatura CHAR(10) PRIMARY KEY,
    Nombre VARCHAR(100),
    IdProfesor INT,
    FOREIGN KEY (IdProfesor) REFERENCES Profesor(IdProfesor)
);

-- Crear la tabla Recibe después de Alumno y Asignatura
CREATE TABLE Recibe (
    NumMatricula INT,
    CodAsignatura CHAR(10),
    CursoEscolar VARCHAR(20),
    PRIMARY KEY (NumMatricula, CodAsignatura),
    FOREIGN KEY (NumMatricula) REFERENCES Alumno(NumMatricula),
    FOREIGN KEY (CodAsignatura) REFERENCES Asignatura(CodAsignatura)
);
