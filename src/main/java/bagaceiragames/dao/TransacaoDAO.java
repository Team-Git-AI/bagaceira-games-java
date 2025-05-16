package bagaceiragames.dao;

import bagaceiragames.model.Transacao;
import bagaceiragames.model.ItemTransacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TransacaoDAO {

    /**
     * Registra uma nova transação (venda) e seus itens no banco de dados.
     * Este método deve idealmente ser transacional (commit/rollback).
     *
     * @param transacao O objeto Transacao com os dados da cabeçalho da venda.
     * @param itens     A lista de ItemTransacao contendo os produtos vendidos.
     * @return true se a venda for registrada com sucesso, false caso contrário.
     */
    public boolean registrarVenda(Transacao transacao, List<ItemTransacao> itens) {
        String sqlTransacao = "INSERT INTO transacoes (usuario_id, valor_total, metodo_pagamento, status_transacao) VALUES (?, ?, ?, ?)";
        String sqlItemTransacao = "INSERT INTO itens_transacao (transacao_id, produto_id, quantidade_vendida, preco_unitario_no_momento_venda) VALUES (?, ?, ?, ?)";
        Connection conexao = null; // Declarar fora do try para poder usar no finally para rollback

        try {
            conexao = ConexaoBD.conectar();
            conexao.setAutoCommit(false); // Inicia a transação manual

            int idTransacaoGerada = -1;

            // 1. Inserir a transação principal e obter o ID gerado
            try (PreparedStatement pstmtTransacao = conexao.prepareStatement(sqlTransacao, Statement.RETURN_GENERATED_KEYS)) {
                pstmtTransacao.setInt(1, transacao.getUsuarioId());
                pstmtTransacao.setBigDecimal(2, transacao.getValorTotal());
                pstmtTransacao.setString(3, transacao.getMetodoPagamento());
                pstmtTransacao.setString(4, transacao.getStatusTransacao());

                int linhasAfetadas = pstmtTransacao.executeUpdate();
                if (linhasAfetadas == 0) {
                    throw new SQLException("Falha ao inserir transação, nenhuma linha afetada.");
                }

                try (ResultSet generatedKeys = pstmtTransacao.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idTransacaoGerada = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Falha ao inserir transação, não foi possível obter o ID gerado.");
                    }
                }
            }

            // 2. Inserir os itens da transação
            if (idTransacaoGerada != -1 && itens != null && !itens.isEmpty()) {
                try (PreparedStatement pstmtItem = conexao.prepareStatement(sqlItemTransacao)) {
                    for (ItemTransacao item : itens) {
                        pstmtItem.setInt(1, idTransacaoGerada);
                        pstmtItem.setInt(2, item.getProdutoId());
                        pstmtItem.setInt(3, item.getQuantidadeVendida());
                        pstmtItem.setBigDecimal(4, item.getPrecoUnitarioNoMomentoVenda());
                        pstmtItem.addBatch(); // Adiciona ao lote para execução em conjunto
                    }
                    pstmtItem.executeBatch(); // Executa todas as inserções de itens
                }
            } else if (itens == null || itens.isEmpty()) {
                // Decide se uma transação sem itens é válida. Se não, lance uma exceção.
                System.out.println("Aviso: Transação registrada sem itens.");
            }

            conexao.commit(); // Se tudo deu certo, comita a transação
            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao registrar venda: " + e.getMessage());
            e.printStackTrace();
            if (conexao != null) {
                try {
                    System.err.println("Tentando reverter transação...");
                    conexao.rollback(); // Em caso de erro, desfaz tudo
                } catch (SQLException exRollback) {
                    System.err.println("Erro ao tentar reverter transação: " + exRollback.getMessage());
                    exRollback.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo auto-commit
                    conexao.close(); // Fecha a conexão
                } catch (SQLException exClose) {
                    System.err.println("Erro ao fechar conexão após transação: " + exClose.getMessage());
                    exClose.printStackTrace();
                }
            }
        }
    }
}