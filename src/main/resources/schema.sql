CREATE TABLE planets (
                         planet_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         radius_km VARCHAR(255),
                         type INT,
                         mass_kg VARCHAR(255),
                         orbital_period_days INT
);

CREATE TABLE moons (
                         moon_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         diameter_km VARCHAR(255),
                         orbital_period_days INT,
                         planet_id
);

CREATE TABLE users (
                         user_id INT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255),
                         role VARCHAR(10);
);

