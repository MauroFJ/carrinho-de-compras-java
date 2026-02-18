public class ItemPedido{
    private final String nome;
    private final int quantidade;
    private final double preco;
    private final double subtotal;

    ItemPedido(String nome, int quantidade, double preco, double subtotal) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.subtotal = subtotal;
    }

    public String getNome() { return this.nome; }
    public int getQuantidade() { return this.quantidade; }
    public double getPreco() { return this.preco; }
    public double getSubtotal() { return this.subtotal; }
}
