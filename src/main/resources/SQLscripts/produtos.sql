CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  categoria_id TINYINT NOT NULL, -- (Ex: Jogo, Console, Acessório)
  plataforma_id TINYINT NOT NULL, -- (Ex: PlayStation 5, Xbox Series X, PC, Nintendo Switch)
  preco DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (categoria_id) REFERENCES categorias(id),
  FOREIGN KEY (plataforma_id) REFERENCES plataformas(id)
);
