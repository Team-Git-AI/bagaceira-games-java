USE loja_games_db;

-- > Incluir CATEGOIAS BASE
INSERT IGNORE INTO categorias (nome) VALUES
('Consoles'),
('Controles'),
('Jogos');

-- > Incluir CONSOLES/PLATAFORMAS
INSERT IGNORE INTO plataformas (nome) VALUES
('Xbox Series S'),
('Xbox Series X'),
('GameBoy Advance'),
('Nintendo 3DS'),
('Nintendo Switch'),
('PlayStation 1'),
('PlayStation 2'),
('PlayStation 3'),
('PlayStation 4'),
('PlayStation 5'),
('Super Nintendo'),
('Nintendo 64'),
('VirtualBoy'),
('3DO'),
('Sega Saturn'),
('Mega Drive'),
('Master System'),
('PC'),
('Xbox 360'),
('PSP'),
('Wii');

-- > Valotes dos CONSOLES
INSERT INTO produtos (nome_produto, categoria_id, plataforma_id, preco_produto) VALUES
('Console Xbox Series S', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Xbox Series S'), 2199.00),
('Console Xbox Series X', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Xbox Series X'), 4399.00),
('Console GameBoy Advance', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'GameBoy Advance'), 399.00),
('Console Nintendo 3DS', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Nintendo 3DS'), 899.00),
('Console Nintendo Switch', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch'), 2299.00),
('Console Nintendo Switch OLED', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch'), 2599.00),
('Console PlayStation 1', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 1'), 299.00),
('Console PlayStation 2', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 2'), 499.00),
('Console PlayStation 3', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 3'), 799.00),
('Console PlayStation 4', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 4'), 1899.00),
('Console PlayStation 5', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 5'), 4499.00),
('Console Super Nintendo', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Super Nintendo'), 349.00),
('Console Nintendo 64', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Nintendo 64'), 499.00),
('Console VirtualBoy', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'VirtualBoy'), 999.00),
('Console 3DO', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = '3DO'), 799.00),
('Console Sega Saturn', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Sega Saturn'), 699.00),
('Console Mega Drive', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Mega Drive'), 299.00),
('Console Master System', (SELECT id FROM categorias WHERE nome = 'Consoles'), (SELECT id FROM plataformas WHERE nome = 'Master System'), 199.00);

-- > Incluir CONTROLES
INSERT INTO produtos (nome_produto, categoria_id, plataforma_id, preco_produto) VALUES
('Controle Original SNES', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'Super Nintendo'), 129.00),
('Controle Dualshock 3', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 3'), 149.00),
('Controle DualShock 4', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 4'), 249.00),
('Controle DualSense PS5', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 5'), 349.00),
('Controle Xbox Wireless (Series S/X)', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'Xbox Series X'), 329.00),
('Controle WaveBird (GameCube/Wii)', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'Wii'), 199.00), -- GameCube não listado, usando Wii
('Controle Original Dreamcast', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'Mega Drive'), 99.00), -- Dreamcast não listado, usando Mega Drive como placeholder
('Controle Wii Remote + Nunchuck Originais', (SELECT id FROM categorias WHERE nome = 'Controles'), (SELECT id FROM plataformas WHERE nome = 'Wii'), 179.00);

-- > Inlcuir JOGOS
INSERT INTO produtos (nome_produto, categoria_id, plataforma_id, preco_produto) VALUES
('Wii Sports Resort', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Wii'), 50.00),
('Final Fantasy VII (Original)', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 1'), 80.00),
('Mario Kart 8 Deluxe', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch'), 100.00),
('God of War: Chains of Olympus', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PSP'),30.00),
('Halo 4', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Xbox 360'), 30.00),
('Resident Evil 5', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 3'), 40.00), -- Também para Xbox 360, PC
('Resident Evil 4 Remake', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 5'), 180.00), -- Também para XBSX, PC
('EA Sports FC 2025 (FIFA 2025)', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PlayStation 5'), 180.00), -- Multiplataforma, escolhendo PS5 como exemplo
('The Legend of Zelda: Breath of the Wild', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch'), 100.00),
('The Legend of Zelda: Ocarina of Time', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Nintendo 64'), 150.00),
('The Legend of Zelda: Minish Cap', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'GameBoy Advance'), 90.00);

-- > FIFA como multiplataforma
INSERT INTO produtos (nome_produto, categoria_id, plataforma_id, preco_produto) VALUES
('EA Sports FC 2025 (FIFA 2025)', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'Xbox Series X'), 349.00),
('EA Sports FC 2025 (FIFA 2025)', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PC'), 299.00);

-- > RE4 Remake para PC
INSERT INTO produtos (nome_produto, categoria_id, plataforma_id, preco_produto) VALUES
('Resident Evil 4 Remake', (SELECT id FROM categorias WHERE nome = 'Jogos'), (SELECT id FROM plataformas WHERE nome = 'PC'), 249.00);

-- > Estoque para Consoles
INSERT INTO estoque (produto_id, quantidade) VALUES
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Xbox Series S' LIMIT 1), 25),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Xbox Series X' LIMIT 1), 15),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console GameBoy Advance' LIMIT 1), 8),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Nintendo 3DS' LIMIT 1), 12),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Nintendo Switch' AND nome_produto NOT LIKE '%OLED%' LIMIT 1), 30), -- Para o Switch normal
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Nintendo Switch OLED' LIMIT 1), 20),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console PlayStation 1' LIMIT 1), 5),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console PlayStation 2' LIMIT 1), 7),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console PlayStation 3' LIMIT 1), 10),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console PlayStation 4' LIMIT 1), 18),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console PlayStation 5' LIMIT 1), 22),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Super Nintendo' LIMIT 1), 6),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Nintendo 64' LIMIT 1), 7),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console VirtualBoy' LIMIT 1), 2),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console 3DO' LIMIT 1), 3),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Sega Saturn' LIMIT 1), 4),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Mega Drive' LIMIT 1), 5),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Console Master System' LIMIT 1), 3);

-- > Estoque para Controles
INSERT INTO estoque (produto_id, quantidade) VALUES
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle Original SNES' LIMIT 1), 15),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle Dualshock 3' LIMIT 1), 20),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle DualShock 4' LIMIT 1), 35),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle DualSense PS5' LIMIT 1), 50),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle Xbox Wireless (Series S/X)' LIMIT 1), 45),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle WaveBird (GameCube/Wii)' LIMIT 1), 10),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle Original Dreamcast' LIMIT 1), 8),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Controle Wii Remote + Nunchuck Originais' LIMIT 1), 22);

-- > Estoque para Jogos
INSERT INTO estoque (produto_id, quantidade) VALUES
((SELECT id_produto FROM produtos WHERE nome_produto = 'Wii Sports Resort' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Wii') LIMIT 1), 40),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Final Fantasy VII (Original)' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PlayStation 1') LIMIT 1), 25),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Mario Kart 8 Deluxe' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch') LIMIT 1), 150),
((SELECT id_produto FROM produtos WHERE nome_produto = 'God of War: Chains of Olympus' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PSP') LIMIT 1), 30),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Halo 4' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Xbox 360') LIMIT 1), 35),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Resident Evil 5' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PlayStation 3') LIMIT 1), 20),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Resident Evil 4 Remake' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PlayStation 5') LIMIT 1), 100),
((SELECT id_produto FROM produtos WHERE nome_produto = 'Resident Evil 4 Remake' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PC') LIMIT 1), 70),
((SELECT id_produto FROM produtos WHERE nome_produto = 'EA Sports FC 2025 (FIFA 2025)' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PlayStation 5') LIMIT 1), 200),
((SELECT id_produto FROM produtos WHERE nome_produto = 'EA Sports FC 2025 (FIFA 2025)' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Xbox Series X') LIMIT 1), 180),
((SELECT id_produto FROM produtos WHERE nome_produto = 'EA Sports FC 2025 (FIFA 2025)' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'PC') LIMIT 1), 150),
((SELECT id_produto FROM produtos WHERE nome_produto = 'The Legend of Zelda: Breath of the Wild' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Nintendo Switch') LIMIT 1), 160),
((SELECT id_produto FROM produtos WHERE nome_produto = 'The Legend of Zelda: Ocarina of Time' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'Nintendo 64') LIMIT 1), 45),
((SELECT id_produto FROM produtos WHERE nome_produto = 'The Legend of Zelda: Minish Cap' AND plataforma_id = (SELECT id FROM plataformas WHERE nome = 'GameBoy Advance') LIMIT 1), 30);

-- > Exibir mensagem de êxito no log
SELECT 'Dados inseridos com sucesso!' AS status;