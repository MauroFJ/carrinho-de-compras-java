public class ItemCarrinho implements ItemVendavel{
    private Produto produto;
    private int quantidade;

    ItemCarrinho(Produto produto){
        if(produto == null) {
            throw new IllegalArgumentException("Produto inválido!");
        }
        this.produto = produto;
        this.quantidade = 1;
    }

    @Override
    public String getNome() {return produto.getNome();}

    @Override
    public double getPreco() {return produto.getPreco();}

    @Override
    public long getID() {return produto.getID();}

    @Override
    public int getQuantidade() {return this.quantidade;}

    @Override
    public void diminuirUnidade(){
        if(this.quantidade == 0) {
            throw new IllegalArgumentException("Quantidade inválida!");
        }
        this.quantidade--;
    }

    @Override
    public void aumentarUnidade(){
        this.quantidade++;
    }

    @Override
    public boolean estaVazio() {
        return this.quantidade == 0;
    }

    @Override
    public double calcularSubtotal() {
        return produto.getPreco() * this.quantidade;
    }

}
