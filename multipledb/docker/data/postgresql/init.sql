\c sample_db;

CREATE TABLE sample_table (
    id SERIAL NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO
    sample_table (name)
VALUES
    ('fuga');