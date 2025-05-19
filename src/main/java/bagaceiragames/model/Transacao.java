package bagaceiragames.model;
import java.math.BigDecimal;
import java.sql.Timestamp;
public class Transacao {
    private int id; // ou id_transacao
    private int usuarioId; // ou id_usuario_fk
    private Timestamp dataTransacao;
    private BigDecimal valorTotal; // ou valor_total_transacao
    private String metodoPagamento;
    private String statusTransacao;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    public Timestamp getDataTransacao() { return dataTransacao; }
    public void setDataTransacao(Timestamp dataTransacao) { this.dataTransacao = dataTransacao; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }
    public String getStatusTransacao() { return statusTransacao; }
    public void setStatusTransacao(String statusTransacao) { this.statusTransacao = statusTransacao; }
}