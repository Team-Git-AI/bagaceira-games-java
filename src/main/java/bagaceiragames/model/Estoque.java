package bagaceiragames.model;
import java.sql.Timestamp;

public class Estoque {
    private int produtoId; // produto_id da tabela estoque
    private int quantidade;
    private Timestamp dataUltimaAtualizacao;
    // Getters e Setters
    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public Timestamp getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(Timestamp dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }
}