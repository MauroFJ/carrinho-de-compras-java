import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private final double total;
    private final List<ItemPedido> itens;
    private StatusPedido status;

    Pedido(ResumoCarrinho resumos) {
        this.itens = new ArrayList<>();

        for (ItemResumo resumo : resumos.getItens()) {
            ItemPedido itempedido = new ItemPedido(
                    resumo.getNome(),
                    resumo.getQuantidade(),
                    resumo.getPreco(),
                    resumo.getSubtotal()
            );
            itens.add(itempedido);
        }
        this.total = resumos.getTotal();
        this.status = StatusPedido.CRIADO;
    }

    public double getTotal() { return this.total; }
    public StatusPedido getStatus() { return this.status; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(this.itens); }

    public void pagar() {
        if (status != StatusPedido.CRIADO) {
            throw new IllegalStateException("Crie o pedido primeiro!");
        }
        this.status = StatusPedido.PAGO;
    }

    public void enviar() {
        if (status == StatusPedido.PAGO) {
            this.status = StatusPedido.ENVIADO;
        } else {
            throw new IllegalStateException("Pedido não foi pago!");
        }
    }

    public void entregar() {
        if (status == StatusPedido.ENVIADO) {
            this.status = StatusPedido.ENTREGUE;
        }else {
            throw new IllegalStateException("Alguma etapa foi pulada!");
        }
    }

    public void cancelar() {
        if (status == StatusPedido.ENVIADO || status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Não é mais possível cancelar!");
        }
        this.status = StatusPedido.CANCELADO;
    }
}
