CREATE TABLE estoque (
  produto_id INT PRIMARY KEY,
  quantidade SMALLINT NOT NULL,
  FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
