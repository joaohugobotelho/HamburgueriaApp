package Hamburgueria;

public class Pedido {
    private String cliente;
    private double valor;
    private Caixa caixa;

    public Pedido(String cliente, double valor){
        this.cliente = cliente;
        this.valor = valor;
        this.caixa = Caixa.getInstance();
    }

    public void finalizarPedido(){
        caixa.adicionarValor((valor));

    }

}
