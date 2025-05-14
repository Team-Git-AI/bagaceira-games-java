CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  login VARCHAR(50) UNIQUE NOT NULL,
  senha_hash VARCHAR(255) NOT NULL -- (Armazenar hash da senha)
);
