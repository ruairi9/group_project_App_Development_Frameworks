INSERT INTO planets ( planet_name, radius_km, type, mass_kg, orbital_period_days)
VALUES
    ('Mercury', 2440, 'Terrestrial', 3.30e23, 88),
    ('Venus', 6052, 'Terrestrial', 4.87e24, 225),
    ('Earth', 6378, 'Terrestrial', 5.97e24, 365.25),
    ('Mars', 3394, 'Terrestrial', 6.42e23, 687),
    ('Jupiter', 71492, 'Gas Giant', 1.90e27, 4333),
    ('Saturn', 60268, 'Gas Giant', 5.68e26, 10759),
    ('Uranus', 25559, 'Ice Giant', 8.69e25, 30687),
    ('Neptune', 24766, 'Ice Giant', 1.02e26, 60190),
    ('TRAPPIST-1 e', 5840, 'Terrestrial', 4.13e24, 5871),
    ('PSR B1257+12 b', 2162, 'Terrestrial', 1.19e23, 25.3),-- is a PSR B1257+12 b (Draugr) and Terrestrial (pulsar planet)
    ('PSR B1257+12 c', 12180, 'Terrestrial', 2.57e25, 66.54), -- Terrestrial (pulsar planet)
    ('WASP-193 b', 104800, 'Gas Giant', 2.63e26, 6.25), -- (ultra-puffy)
    ('Kepler-16 b', 58860, 'Gas Giant', 6.31e26, 228.78); -- (circumbinary)


INSERT INTO moons (moon_name, diameter_km, orbital_period_days, planet_id)
VALUES
    ('Moon', 3474, 27.3, 3),
    ('Phobos', 22.5, 0.319, 4),
    ('Deimos', 12.4, 1.263, 4),
    ('Io', 3643, 1.77, 5),
    ('Europa', 3121, 3.55, 5),
    ('Ganymede', 5268, 7.15, 5),
    ('Callisto', 4820, 16.69, 5),
    ('Amalthea', 250, 0.498, 5),
    ('Titan', 5150, 15.95, 6),
    ('Rhea', 1528, 4.52, 6),
    ('Enceladus', 504, 1.37, 6),
    ('Mimas', 396, 0.94, 6),
    ('Iapetus', 1469, 79.32, 6),
    ('Titania', 1578, 8.71, 7),
    ('Oberon', 1523, 13.46, 7),
    ('Ariel', 1158, 2.52, 7),
    ('Umbriel', 1169, 4.14, 7),
    ('Miranda', 472, 1.41, 7),
    ('Triton', 2706, -5.88, 8),
    ('Proteus', 420, 1.12, 8);


INSERT INTO users (username, password, role)
VALUES
    ('I love moon', 'moon Iapetus is the best' , 'STUDENT'),
    ('tom', 'the638c' , 'STAFF'),
    ('I hate moon', 'tpsb2884%%m' , 'ADMIN'),
    ('bob', '1234' , 'STUDENT');



