CREATE TABLE itens_transacao (
  transacao_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade SMALLINT NOT NULL,
  preco_unitario DECIMAL(10, 2) NOT NULL, -- Preço no momento da venda
  PRIMARY KEY (transacao_id, produto_id),
  FOREIGN KEY (transacao_id) REFERENCES transacoes(id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id)
);
