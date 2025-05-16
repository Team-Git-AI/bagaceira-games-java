CREATE DATABASE IF NOT EXISTS loja_games_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE loja_games_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (nome, login, senha) VALUES ('Administrador', 'root', 'root');
INSERT INTO usuarios (nome, login, senha) VALUES ('Juca Machuca', 'juca_machuca', 'machucador');