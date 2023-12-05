CREATE TABLE IF NOT EXISTS investment (
   id SERIAL PRIMARY KEY,
   category VARCHAR(255) NOT NULL,
   description VARCHAR(255) NOT NULL,
   value NUMERIC(10, 2) NOT NULL,
   tax_inflation_id INT REFERENCES taxes(id)
);