[![made Language {generic badge}](https://img.shields.io/badge/Made%20with-Java%20language-8A2BE2)](https://github.com/alanmugiwara)
[![made Language {generic badge}](https://img.shields.io/badge/Made%20with-SQL%20language-8A2BE2)](https://github.com/alanmugiwara)
[![create date](https://badges.pufler.dev/created/Team-Git-AI/bagaceira-games-java?color=8A2BE2)](https://github.com/alanmugiwara)
[![last update date](https://badges.pufler.dev/Updated/Team-Git-AI/bagaceira-games-java?color=8A2BE2)](https://github.com/alanmugiwara)

[![contributors](https://img.shields.io/github/contributors/alanmugiwara/login-system-c?color=8A2BE2)](https://github.com/alanmugiwara)
[![issues counter](https://img.shields.io/github/issues/alanmugiwara/login-system-c?color=8A2BE2)](https://github.com/alanmugiwara)
[![repo size](https://img.shields.io/github/repo-size/alanmugiwara/login-system-c?color=8A2BE2)](https://github.com/alanmugiwara)
[![directory size](https://img.shields.io/github/directory-file-count/alanmugiwara/login-system-c?color=8A2BE2)](https://github.com/alanmugiwara)

## Projeto: Loja de Games — Aplicativo Java Swing com MySQL (Janela Única)

### Objetivo
Criar um sistema desktop de gerenciamento de vendas para uma loja de games. A aplicação será feita em Java Swing, com MySQL, utilizando uma interface única baseada em JPanel e CardLayout, incluindo:

- Login de usuário;
- Listagem e filtragem de produtos;
- Controle de estoque (verificação de quantidade);
- Carrinho de compras e finalização de venda.

## 1. Ferramentas e Tecnologias

| Área                 | Ferramenta/Tecnologia                                                                                                                                                                                                                         |
|:---------------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Linguagem            | [Java (JDK 24)](https://download.oracle.com/java/24/latest/jdk-24_windows-x64_bin.exe)                                                                                                                                                        |
| Interface Gráfica    | [Java Swing (com CardLayout)](https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/)                                                                                                                                                                                                               |
| IDE                  | [IntelliJ IDEA Community](https://www.jetbrains.com/pt-br/idea/download/download-thanks.html?platform=windows&code=IIC)                                                                                                                       |
| Banco de Dados       | [MySQL](https://sourceforge.net/projects/xampp/files/XAMPP%20Windows/8.2.12/xampp-windows-x64-8.2.12-0-VS16-installer.exe) + [MySQL Workbench](https://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community-8.0.42-winx64.msi) |
| Conexão BD           | JDBC (mysql-connector-java)                                                                                                                                                                                                                   |
| Controle de Versão   | [Git](https://github.com/git-for-windows/git/releases/download/v2.49.0.windows.1/Git-2.49.0-64-bit.exe) + GitHub                                                                                                                              |
| Gerenciamento        | [Trello](https://trello.com/b/tuoe0qsU/bagaceira-games)                                                                                                                                                                                       |

## 2. Estrutura de Banco de Dados (Tablelas) (MySQL)

- usuarios
- categorias
- plataformas
- produtos
- estoque
- transacoes
- itens_transacao

## 3. Interface Gráfica (Swing | Janela Única)

#### Estrutura da Janela
- Janela Principal (JFrame): Uma única janela fixa que servirá como contêiner principal.
- Gerenciador de Layout: Um JPanel central dentro do JFrame utilizando CardLayout para alternar entre os diferentes painéis de conteúdo. (Alternativamente, um JTabbedPane com abas escondidas).

## Painéis (JPanel) a serem gerenciados pelo CardLayout:
#### 1.  LoginPanel (Painel inicial)
- Campos: JTextField para Login, JPasswordField para Senha.
- Botão: JButton "Entrar".
- Ação: Ao autenticar com sucesso, o CardLayout exibirá o LojaPanel.

### 2. LojaPanel (Painel principal após login)
##### Filtros:
- JComboBox 1: Categoria (Todos, Jogo, Console, Acessório).
- JComboBox 2: Plataforma (Todos, PlayStation 5, etc.).
- Opcional: JTextField para busca por nome.

#####  Listagem de Produtos Disponíveis:
- Jlist exibindo produtos filtrados (Nome, Categoria, Plataforma, Preço, Estoque).

#####  Seleção e Adição ao Carrinho:
- Seleção de um item na lista.
- JSpinner: Quantidade desejada.
- Botão: JButton "Adicionar ao Carrinho".

#####  Carrinho de Compras:
- JList: Exibe os itens adicionados (Produto, Quantidade, Preço Unitário, Subtotal).
- Label: Exibe o Preço Total do carrinho.

#####  Ações do Carrinho:
- Botão: JButton "Remover Item Selecionado" (do carrinho).
- Botão: JButton "Esvaziar Carrinho".

#####  Finalização:
- Botão: JButton "Finalizar Compra".
- Ação: Registra a transação no banco, atualiza o estoque e limpa o carrinho. Exibe mensagem de sucesso.

#####  Outros:
- Botão: JButton "Logout" (retorna ao LoginPanel).

# Demonstração
![Demonsraoção](https://github.com/Team-Git-AI/bagaceira-games-java/blob/main/src/main/resources/demo-img.gif?raw=true)

## 4. Organização do Código (MVC Simplificado)

```
LojaGames/
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── bagaceiragames/
│ │ │ ├── model/ # Classes de domínio (POJOs) >>Plain Old Java Objects<< Classe java "pelada", sem frameworks ou ferramentas na classe. Só código java puro.
│ │ │ │ ├── Usuario.java
│ │ │ │ ├── Produto.java
│ │ │ │ ├── Estoque.java # Pode ser combinado com Produto ou ter DTO
│ │ │ │ ├── Transacao.java
│ │ │ │ └── ItemTransacao.java
│ │ │ ├── view/ # Classes da Interface Gráfica (Swing)
│ │ │ │ ├── MainWindow.java # JFrame principal com CardLayout
│ │ │ │ ├── LoginPanel.java # JPanel para login
│ │ │ │ └── LojaPanel.java # JPanel para a loja/carrinho
│ │ │ ├── controller/ # Lógica de controle e interação UI <-> Modelo
│ │ │ │ ├── LoginController.java
│ │ │ │ └── LojaController.java
│ │ │ ├── dao/ # Data Access Objects (Interação com BD)
│ │ │ │ ├── ConexaoBD.java # Gerencia a conexão JDBC
│ │ │ │ ├── UsuarioDAO.java
│ │ │ │ ├── ProdutoDAO.java # Inclui métodos para buscar por filtros
│ │ │ │ ├── EstoqueDAO.java # Métodos para verificar/atualizar estoque
│ │ │ │ └── TransacaoDAO.java # Inclui métodos para salvar transação e itens
│ │ │ └── main/ # Ponto de entrada da aplicação
│ │ │ └── LojaGamesApp.java # Cria MainWindow e inicia a aplicação
│ │ └── resources/SQLscripts/ # Arquivos de configuração, SQL scripts (opcional)
│ └──
└── pom.xml # (Se usar Maven) ou arquivos de build do Gradle
```

## 5. Planejamento Ágil com 4 Devs (Exemplo)

### Papéis Temporários (Flexíveis)

- Dev 1 (Backend Lead): Responsável pela estrutura do Banco de Dados (scripts SQL), classes DAO (ConexaoBD, UsuarioDAO, ProdutoDAO, EstoqueDAO, TransacaoDAO) e configuração inicial da conexão JDBC.

- Dev 2 (Frontend Lead): Responsável pela criação dos painéis Swing (LoginPanel, LojaPanel) com seus componentes visuais (layout, campos, botões, tabelas, combos), sem a lógica de eventos inicialmente.

- Dev 3 (Business Logic Lead): Responsável pela implementação da lógica de negócio nos Controllers (LoginController, LojaController), regras de validação, lógica do carrinho de compras (adicionar, remover, calcular total), e verificação de estoque.

- Dev 4 (Integration & CI/CD Lead): Responsável pela configuração do MainWindow com CardLayout, integração dos painéis com os controllers (adição de ActionListeners), gerenciamento do fluxo de navegação entre painéis, controle de versão (Git/GitHub), e garantia da integração contínua do trabalho da equipe.

### Sprints (Ciclos de 1 semana)

| Sprint | Tarefas Principais                                                                                                      | Entregável Chave                      |
| :----- | :---------------------------------------------------------------------------------------------------------------------- | :------------------------------------ |
| 1  | Definir e criar BD (SQL Scripts). Implementar ConexaoBD e UsuarioDAO. Criar LoginPanel básico. Implementar LoginController e funcionalidade de login. Configurar MainWindow com CardLayout e painel de login inicial. Configurar Git Repo. | Login funcional (valida no BD).       |
| 2  | Implementar ProdutoDAO e EstoqueDAO. Criar LojaPanel com ComboBoxes, Tabela de Produtos e área do Carrinho (layout). Implementar filtros dinâmicos nos ComboBoxes (LojaController busca dados via ProdutoDAO). Exibir produtos na tabela. | Interface da loja exibe produtos filtrados. |
| 3  | Implementar lógica de adicionar/remover itens do carrinho (LojaController). Atualizar exibição da tabela do carrinho e total. Implementar TransacaoDAO. Implementar funcionalidade "Finalizar Compra" (verifica estoque, salva transação/itens, atualiza estoque). | Carrinho funcional, compra salva no BD. |
| 4  | Implementar botão "Logout". Realizar testes de integração completos (fluxo login -> compra -> logout). Refatoração de código (limpeza, comentários). Revisão de bugs. Preparar documentação básica. Merge final e build. | Aplicação integrada e testada.      |

## 6. Backlog Técnico Priorizado

| ID | Tarefa                                                                 | Prioridade | Responsável Inicial (Sugestão) | Sprint |
| :- | :--------------------------------------------------------------------- | :--------- | :----------------------------- | :----- |
| 1  | Criar scripts SQL para criação das tabelas e relacionamentos           | Alta   | Dev 1                          | 1      |
| 2  | Implementar classe ConexaoBD.java para gerenciar conexão MySQL       | Alta   | Dev 1                          | 1      |
| 3  | Implementar UsuarioDAO e método de autenticação (findByLogin)     | Alta   | Dev 1                          | 1      |
| 4  | Criar LoginPanel.java com campos e botão                            | Alta   | Dev 2                          | 1      |
| 5  | Criar MainWindow.java com CardLayout                             | Alta   | Dev 4                          | 1      |
| 6  | Implementar LoginController para validar login e trocar painel      | Alta   | Dev 3 & Dev 4                  | 1      |
| 7  | Implementar ProdutoDAO (buscar todos, buscar por filtros)            | Alta   | Dev 1                          | 2      |
| 8  | Implementar EstoqueDAO (verificar quantidade, decrementar)          | Alta   | Dev 1                          | 2      |
| 9  | Criar LojaPanel.java com layout (filtros, tabela produtos, carrinho) | Alta   | Dev 2                          | 2      |
| 10 | Implementar LojaController - Carregar filtros e produtos iniciais    | Média  | Dev 3                          | 2      |
| 11 | Implementar lógica de filtragem dinâmica nos ComboBoxes (LojaPanel) | Média  | Dev 3 & Dev 2                  | 2      |
| 12 | Implementar lógica de adicionar item ao carrinho (LojaController)    | Alta   | Dev 3                          | 3      |
| 13 | Implementar lógica de remover item/esvaziar carrinho (LojaController)| Alta   | Dev 3                          | 3      |
| 14 | Atualizar dinamicamente a tabela do carrinho e o total (LojaPanel)   | Alta   | Dev 2 & Dev 3                  | 3      |
| 15 | Implementar TransacaoDAO (salvar transação e itens)                | Alta   | Dev 1                          | 3      |
| 16 | Implementar botão "Finalizar Compra" (chama LojaController)         | Alta   | Dev 3 & Dev 4                  | 3      |
| 17 | Implementar botão "Logout" (LojaPanel -> LoginPanel)              | Média  | Dev 4                          | 4      |
| 18 | Testes de integração e fluxo completo                                 | Alta   | Todos                          | 4      |
| 19 | Refatoração, comentários e documentação final                          | Média  | Todos                          | 4      |

## 7. Boas Práticas (Adaptado Scrum + PMBOK7)

- Entregas incrementais e testáveis por painel
- Cada membro faz git pull e git push antes/depois das tarefas
- Comunicação constante entre pares (Discord, grupo, etc.)
- Foco em código limpo e comentado
- Anexar artefatos/documentos no repositório (diagramas UML, backlog, plano)


