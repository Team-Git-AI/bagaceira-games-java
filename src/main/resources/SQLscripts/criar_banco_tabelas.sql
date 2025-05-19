CREATE DATABASE IF NOT EXISTS loja_games_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE loja_games_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (nome, login, senha) VALUES ('Administrador', 'root', 'root');
INSERT INTO usuarios (nome, login, senha) VALUES ('Juca Machuca', 'juca_machuca', 'machucador');

INSERT INTO usuarios (nome, login, senha) VALUES ('Administrador', 'root', 'root');
INSERT INTO usuarios (nome, login, senha) VALUES ('Usuário Teste', 'juca', 'machuca');

CREATE TABLE IF NOT EXISTS categorias (
  id TINYINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS plataformas (
  id TINYINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS produtos (
  id_produto INT AUTO_INCREMENT PRIMARY KEY,
  nome_produto VARCHAR(100) NOT NULL,
  categoria_id TINYINT NOT NULL, -- > (Jogo, Console, Acessório)
  plataforma_id TINYINT NOT NULL, -- > (PlayStation 5, Xbox Series X, PC, Nintendo Switch)
  preco_produto DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (categoria_id) REFERENCES categorias(id),
  FOREIGN KEY (plataforma_id) REFERENCES plataformas(id)
);

CREATE TABLE IF NOT EXISTS transacoes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  usuario_id INT,
  data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  valor_total DECIMAL(10, 2) NOT NULL,

  FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE IF NOT EXISTS itens_transacao (
  transacao_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade SMALLINT NOT NULL,
  preco_unitario_no_momento_venda DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (transacao_id, produto_id),

  FOREIGN KEY (transacao_id) REFERENCES transacoes(id),
  FOREIGN KEY (produto_id) REFERENCES produtos(id_produto)
);

CREATE TABLE IF NOT EXISTS estoque (
  produto_id INT PRIMARY KEY,
  quantidade SMALLINT NOT NULL,
  data_ultima_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

FOREIGN KEY (produto_id) REFERENCES produtos(id_produto)
  ON DELETE CASCADE -- > Controla a quantidade em estoque
  ON UPDATE CASCADE -- > Controla a quantidade em estoqu
);