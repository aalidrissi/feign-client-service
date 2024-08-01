
CREATE TABLE IF NOT EXISTS Adress (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255)
);

INSERT INTO Adress (id,label)
VALUES (1,'Rabat');

INSERT INTO Adress (id,label)
VALUES (2,'Casa');