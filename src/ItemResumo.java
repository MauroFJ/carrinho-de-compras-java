public class ItemResumo {
    private String nome;
    private int quantidade;
    private double subtotal;
    private double preco;

    ItemResumo(String nome, int quantidade, double preco, double subtotal) {
        this.nome = nome;
        this.subtotal = subtotal;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return this.nome; }
    public int getQuantidade() { return this.quantidade; }
    public double getPreco() { return this.preco; }
    public double getSubtotal() { return this.subtotal; }
}
