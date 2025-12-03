CREATE DATABASE IF NOT EXISTS capacitaciones DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE capacitaciones;

-- (Si prefieres no usar JPA auto-ddl)
CREATE TABLE usuarios (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);

CREATE TABLE instructores (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255),
  email VARCHAR(255)
);

CREATE TABLE cursos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(255),
  descripcion TEXT,
  fecha_inicio DATE,
  fecha_fin DATE,
  instructor_id BIGINT,
  FOREIGN KEY (instructor_id) REFERENCES instructores(id)
);

CREATE TABLE inscripciones (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  empleado_username VARCHAR(255),
  fecha_inscripcion DATETIME,
  curso_id BIGINT,
  FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
INSERT INTO usuarios (username, password, role) VALUES
('admin', '$2a$10$Dow1V5/YVq9FQDGm3dxa0eHw41fSA3hVlRsNi0gJMXYDvzSuCYV8a', 'ADMIN'),
('fherrera', '$2a$10$Dow1V5/YVq9FQDGm3dxa0eHw41fSA3hVlRsNi0gJMXYDvzSuCYV8a', 'USER');
