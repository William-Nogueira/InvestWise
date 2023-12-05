CREATE TABLE IF NOT EXISTS expense (
   id SERIAL PRIMARY KEY,
   description VARCHAR(255) NOT NULL,
   value NUMERIC(10, 2) NOT NULL,
   date DATE NOT NULL,
   user_id UUID REFERENCES users(id)
);