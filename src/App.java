import java.util.List;

public class App {
    public static void main(String[] args){
        Carrinho carrinho = new Carrinho();
        Produto cafe = new Produto(0, "Café", 13.90);
        Produto leite = new Produto(1, "Leite", 9.90);
        Produto manteiga = new Produto(2, "Manteiga", 5.90);
        Produto pao = new Produto(3, "Pão Francês", 0.5);

        carrinho.adicionarProduto(cafe);
        carrinho.adicionarProduto(leite);
        carrinho.adicionarProduto(manteiga);
        carrinho.adicionarProduto(pao);
        carrinho.adicionarProduto(pao);
        carrinho.adicionarProduto(pao);
        carrinho.adicionarProduto(pao);
        carrinho.adicionarProduto(pao);
        carrinho.adicionarProduto(pao);

        carrinho.removerUnidade(3);
        carrinho.removerUnidade(3);

        ResumoCarrinho resumo = carrinho.gerarResumo();
        Pedido pedido = new Pedido(resumo);

        List<ItemPedido> itens = pedido.getItens();

        for(ItemPedido item : itens) {
            System.out.printf("%s - R$ %.2f X %d = R$ %.2f", item.getNome(), item.getPreco(), item.getQuantidade(), item.getSubtotal());
            System.out.println();
        }

        System.out.println("-----------------------------------");

        System.out.printf("Valor total: %.2f", pedido.getTotal());
        System.out.println();

        System.out.println("-----------------------------------");


        System.out.println("Status do pedido: " + pedido.getStatus());
        pedido.pagar();
        System.out.println("Status do pedido: " + pedido.getStatus());
        pedido.enviar();
        System.out.println("Status do pedido: " + pedido.getStatus());
        pedido.entregar();
        System.out.println("Status do pedido: " + pedido.getStatus());
    }
}
