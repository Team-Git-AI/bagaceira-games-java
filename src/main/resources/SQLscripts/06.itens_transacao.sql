CREATE TABLE IF NOT EXISTS itens_transacao (
  transacao_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade SMALLINT NOT NULL,
  preco_unitario_no_momento_venda DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (transacao_id, produto_id),

  FOREIGN KEY (transacao_id) REFERENCES transacoes(id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id_produto)
);
