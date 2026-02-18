import java.util.ArrayList;
import java.util.List;

public class ResumoCarrinho {
    private List<ItemResumo> itens;
    private double total;

    ResumoCarrinho(List<ItemResumo> itens, double total) {
        this.itens = itens;
        this.total = total;
    }

    public List<ItemResumo> getItens() { return this.itens; }
    public double getTotal() { return this.total; }
}
