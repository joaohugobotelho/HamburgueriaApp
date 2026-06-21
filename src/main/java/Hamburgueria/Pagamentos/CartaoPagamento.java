package Hamburgueria.Pagamentos;

public class CartaoPagamento implements Pagamento{

    private CartaoApi cartao;

    public CartaoPagamento(CartaoApi cartao){
        this.cartao = cartao;
    }

    @Override
    public void pagar(double valor){
        cartao.pagamentoCartao(valor);
    }
}
