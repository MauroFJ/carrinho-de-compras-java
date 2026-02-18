import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemVendavel> itens = new ArrayList<>();

    void adicionarProduto(Produto produto) {
        if(produto == null) {
            throw new IllegalArgumentException("Produto não pode ser null!");
        }
        for(int i = 0; i < itens.size(); i++) {
            ItemVendavel item = itens.get(i);
            if(item.getID() == produto.getID()) {
                item.aumentarUnidade();
                return;
            }
        }
        ItemCarrinho item = new ItemCarrinho(produto);
        itens.add(item);
    }

    double calcularTotal() {
        double total = 0;
        for(ItemVendavel item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

   ResumoCarrinho gerarResumo() {
        List<ItemResumo> itensresumo = new ArrayList<>();
        double total = 0;

        for(ItemVendavel i : itens) {
            ItemResumo item = new ItemResumo(i.getNome(),i.getQuantidade(),i.getPreco(), i.calcularSubtotal());
            itensresumo.add(item);
            total += item.getSubtotal();
        }

        ResumoCarrinho resumo = new ResumoCarrinho(itensresumo, total);
        return resumo;
   }

    private ItemVendavel buscarItem(long id){
        for(int i = 0; i < itens.size(); i++){
            ItemVendavel item = itens.get(i);
            if(item.getID() == id){
                return item;
            }
        }
        return null;
    }

//    Carrinho sabia demais!
//    void alterarQuantidade(String nomeProduto, int quantidade) {
//        for(int i = 0; i < itens.size(); i++) {
//            ItemVendavel item = itens.get(i);
//            if (item.getNome().equals(nomeProduto)) {
//                item.definirQuantidade(quantidade);
//                System.out.println("Quantidade alterada: "+ item.getNome() + " -> " + item.getQuantidade());
//            }
//        }
//    }

    void adicionarUnidade(ItemVendavel item){
        item.aumentarUnidade();
    }

    void removerUnidade(long id) {
         ItemVendavel item = buscarItem(id);
         if(item == null) throw new IllegalArgumentException("Item não existe");
         item.diminuirUnidade();
         if(item.estaVazio()){
             itens.removeIf(i -> i.getID() == id);
         }
    }

    public boolean estaVazio() {
        return (itens.isEmpty());
    }

    public void limpar() {
       itens.clear();
    }

    public Pedido finalizarCompra() {
        if(estaVazio()) {
            throw new IllegalStateException("Não podemos finalizar compra sem nada");
        }
        Pedido pedido = new Pedido(gerarResumo());
        limpar();
        return pedido;
    }

//    void removerItem(String nomeProduto) {
//
//        boolean removido = itens.removeIf(prod -> prod.getNome().equals(nomeProduto));
//        if(removido) {
//            System.out.println("Item removido: "+ nomeProduto);
//        }else{
//            System.out.println("Item não existe nos produtos!");
//        }
//        for(int i = 0; i < produtos.size(); i++) {
//            Produto p = produtos.get(i);
//            if(p.nome.equals(nomeProduto)) {
//                System.out.println("Item removido: " + p.nome);
//            }
        //Nunca remover elementos de uma coleção utilizando for tradicional!!
//        }
//    }

    int QuantidadeItensCarrinho() {
        int quantidadeTotal = 0;
        for(ItemVendavel item : itens) {
            quantidadeTotal += item.getQuantidade();
        }
        return quantidadeTotal;
    }

}
