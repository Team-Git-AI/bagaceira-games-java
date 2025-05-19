package bagaceiragames.model;

public class Plataforma {
    private int id; // É a a 'id' TINYINT na tabela plataformas
    private String nome; // É o 'nome' VARCHAR(50) na tabela plataformas

    public Plataforma() {
    }

    public Plataforma(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}