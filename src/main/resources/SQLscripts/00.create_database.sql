CREATE DATABASE IF NOT EXISTS loja_games_db 
CHARACTER SET utf8mb4 --> Suporta alfabeto latino, ideogramas, etc. e emojis
COLLATE utf8mb4_unicode_ci; --> Ignora diferenças entre caixa alta/baixa.

USE loja_games_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL --> Armazena senhas hasheadas!

);