public interface ItemVendavel {
    String getNome();
    double getPreco();
    int getQuantidade();
    long getID();

    void diminuirUnidade();
    void aumentarUnidade();
    boolean estaVazio();
    double calcularSubtotal();
}
