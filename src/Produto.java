public class Produto{
    private long id;
    private String nome;
    private double preco;

    Produto(long getID, String nome, double preco) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto tem que ser declarado");
        }
        if(preco <= 0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a zero!");
        }
        if(getID < 0) {
            throw new IllegalArgumentException("ID precisa ser válido!");
        }
        this.nome = nome;
        this.preco = preco;
        this.id = getID;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public long getID(){
        return this.id;
    }

//    @Override
//    public void diminuirUnidade() {
//        if(this.quantidade == 0) {
//            throw new IllegalArgumentException("Quantidade não pode ser diminuida!");
//        }
//        this.quantidade--;
//    }

//    @Override
//    public void aumentarUnidade() {
//        this.quantidade++;
//    }
//
//    @Override
//    public boolean estaVazio(){
//        if(this.quantidade == 0){
//            return true;
//        }
//        return false;
//    }
//    public void definirQuantidade(int quantidade) {
//        if(quantidade < 0) {
//            throw new IllegalArgumentException("Quantidade inválida!");
//        }
//        this.quantidade = quantidade;
//    }
//    @Override
//    public double calcularSubtotal() {
//        return this.preco * this.quantidade;
//    }
}
