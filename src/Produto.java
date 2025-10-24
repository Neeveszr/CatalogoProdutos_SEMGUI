public class Produto {
    private String id;
    private String nome;
    private double preco;

    // CONSTRUTOR
    public Produto(String id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    // ALGUNS GETTERS E SETTERS
    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }

}
