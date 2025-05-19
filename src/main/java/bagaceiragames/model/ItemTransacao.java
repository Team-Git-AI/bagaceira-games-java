package bagaceiragames.model;
import java.math.BigDecimal;
public class ItemTransacao {
    // private int idItemTransacao; // Se você tiver uma PK separada para itens_transacao
    private int transacaoId; // transacao_id
    private int produtoId;   // produto_id
    private int quantidadeVendida;
    private BigDecimal precoUnitarioNoMomentoVenda;
    // Getters e Setters
    // ... (implemente todos os getters e setters)
    public int getTransacaoId() { return transacaoId; }
    public void setTransacaoId(int transacaoId) { this.transacaoId = transacaoId; }
    public int getProdutoId() { return produtoId; }
    public void setProdutoId(int produtoId) { this.produtoId = produtoId; }
    public int getQuantidadeVendida() { return quantidadeVendida; }
    public void setQuantidadeVendida(int quantidadeVendida) { this.quantidadeVendida = quantidadeVendida; }
    public BigDecimal getPrecoUnitarioNoMomentoVenda() { return precoUnitarioNoMomentoVenda; }
    public void setPrecoUnitarioNoMomentoVenda(BigDecimal precoUnitarioNoMomentoVenda) { this.precoUnitarioNoMomentoVenda = precoUnitarioNoMomentoVenda; }
}