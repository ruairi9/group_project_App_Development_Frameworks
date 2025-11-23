CREATE TABLE planets (
                         planet_id INT PRIMARY KEY AUTO_INCREMENT,
                         planet_name VARCHAR(255) NOT NULL UNIQUE,
                         radius_km INT,
                         type VARCHAR(255),
                         mass_kg DOUBLE,
                         orbital_period_days INT
);

CREATE TABLE moons (
                         moon_id INT PRIMARY KEY AUTO_INCREMENT,
                         moon_name VARCHAR(255) NOT NULL UNIQUE,
                         diameter_km INT,
                         orbital_period_days INT,
                         planet_id INT,
                         FOREIGN KEY (planet_id) REFERENCES planets(planet_id)
);

CREATE TABLE users (
                         user_id INT PRIMARY KEY AUTO_INCREMENT,
                         username VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255),
                         role VARCHAR(10)
);

