CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  login VARCHAR(50) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (nome, login, senha) VALUES ('Administrador', 'root', 'root');
INSERT INTO usuarios (nome, login, senha) VALUES ('Usuário Teste', 'juca', 'machuca');