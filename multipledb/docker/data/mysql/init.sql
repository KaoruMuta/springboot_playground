DROP DATABASE IF EXISTS sample_db;

CREATE DATABASE sample_db;

USE sample_db;

DROP TABLE IF EXISTS sample_table;

CREATE TABLE sample_table (
    id INT(20) AUTO_INCREMENT NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
) DEFAULT CHARACTER SET = utf8;

INSERT INTO
    sample_table (name)
VALUES
    ("hoge");