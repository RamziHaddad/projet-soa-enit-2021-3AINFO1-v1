CREATE TABLE ProductDB (
	id serial PRIMARY KEY,
	title VARCHAR ( 100 ) UNIQUE NOT NULL,
	price decimal  NOT NULL
);