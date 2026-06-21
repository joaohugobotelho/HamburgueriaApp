package Hamburgueria.Pagamentos;

public class CartaoApi {
    public double ultimoPagamento;

    public void pagamentoCartao(double valor){
        ultimoPagamento = valor;
    }
}
