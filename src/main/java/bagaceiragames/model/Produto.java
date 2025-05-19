package bagaceiragames.model;
import java.math.BigDecimal; // Para preço
public class Produto {
    private int id; // Ou id_produto
    private String nome; // Ou nome_produto
    private int categoriaId; // Ou id_categoria_fk
    private int plataformaId; // Ou id_plataforma_fk
    private BigDecimal preco; // Ou preco_produto

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getCategoriaId() { return categoriaId; }
    public void setCategoriaId(int categoriaId) { this.categoriaId = categoriaId; }
    public int getPlataformaId() { return plataformaId; }
    public void setPlataformaId(int plataformaId) { this.plataformaId = plataformaId; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}