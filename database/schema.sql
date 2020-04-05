CREATE USER IF NOT EXISTS 'busystem'@'%' IDENTIFIED BY 'busystem';
CREATE DATABASE IF NOT EXISTS busystem;
GRANT ALL PRIVILEGES ON busystem.* TO 'busystem'@'%';
FLUSH PRIVILEGES;

USE busystem;

DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS trip;
DROP TABLE IF EXISTS line;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS bus;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(64) NOT NULL UNIQUE,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
	password VARCHAR(512) NOT NULL,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	email VARCHAR(256) UNIQUE
);

CREATE TABLE bus (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	model VARCHAR(64) NOT NULL,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	seats INTEGER NOT NULL
);

CREATE TABLE city (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    area_number INTEGER NOT NULL UNIQUE
);

CREATE TABLE line (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    start_id INTEGER NOT NULL,
    destination_id INTEGER NOT NULL,
	FOREIGN KEY (start_id) REFERENCES city (id),
	FOREIGN KEY (destination_id) REFERENCES city (id)
);

CREATE TABLE trip (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    line_id INTEGER NOT NULL,
    bus_id INTEGER NOT NULL,
    departure_time TIME NOT NULL,
    trip_duration TIME NOT NULL,
	FOREIGN KEY (bus_id) REFERENCES bus (id),
	FOREIGN KEY (line_id) REFERENCES line (id)
);

CREATE TABLE ticket (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    trip_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
	FOREIGN KEY (trip_id) REFERENCES trip (id),
	FOREIGN KEY (user_id) REFERENCES user (id)
);
