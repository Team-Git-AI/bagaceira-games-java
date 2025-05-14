CREATE TABLE IF NOT EXISTS produtos (
  id_produto INT AUTO_INCREMENT PRIMARY KEY,
  nome_produto VARCHAR(100) NOT NULL,
  categoria_id TINYINT NOT NULL, --> (Jogo, Console, Acessório)
  plataforma_id TINYINT NOT NULL, --> (PlayStation 5, Xbox Series X, PC, Nintendo Switch)
  preco_produto DECIMAL(10, 2) NOT NULL,
  
  FOREIGN KEY (categoria_id) REFERENCES categorias(id),
  FOREIGN KEY (plataforma_id) REFERENCES plataformas(id)
);