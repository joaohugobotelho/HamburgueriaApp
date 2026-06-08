package Hamburgueria.Sistema;

public class SistemaPedido {

    private Estoque estoque;
    private Pagamento pagamento;
    private Cozinha cozinha;
    private Entrega entrega;

    public SistemaPedido(){
        estoque = new Estoque();
        pagamento = new Pagamento();
        cozinha = new Cozinha();
        entrega = new Entrega();
    }
    public String realizarPedido(){
        return estoque.verificarEstoque() + "/" +
                pagamento.processarPagamento() +
                cozinha.prepararPedido() +
                entrega.gerarEntrega();
    }
}
