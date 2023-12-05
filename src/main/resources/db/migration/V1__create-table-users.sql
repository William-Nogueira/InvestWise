create table users (
   id UUID PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   login VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   roles VARCHAR(255) NOT NULL
);