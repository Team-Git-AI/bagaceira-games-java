CREATE TABLE IF NOT EXISTS transacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,       
  usuario_id INT,                          
  data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  valor_total DECIMAL(10, 2) NOT NULL,

  FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);