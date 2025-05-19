CREATE TABLE IF NOT EXISTS estoque (
  produto_id INT PRIMARY KEY,
  quantidade SMALLINT NOT NULL,
  data_ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

FOREIGN KEY (produto_id) REFERENCES produtos(id_produto)
  ON DELETE CASCADE -- > Controla a quantidade em estoque
  ON UPDATE CASCADE -- > Controla a quantidade em estoqu
);