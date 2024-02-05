CREATE TABLE IF NOT EXISTS recipe (
    id SERIAL PRIMARY KEY,
    label VARCHAR(60),
    calories REAL
);
CREATE TABLE IF NOT EXISTS ingredient (
    id SERIAL PRIMARY KEY,
    recipe_id INT,
    text VARCHAR(60),
    quantity INT,
    measure VARCHAR(15),
    name VARCHAR(30),
    category VARCHAR(15),
    FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);