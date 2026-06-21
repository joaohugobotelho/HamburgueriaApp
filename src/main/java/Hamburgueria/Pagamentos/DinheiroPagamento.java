package Hamburgueria.Pagamentos;

public class DinheiroPagamento implements Pagamento{

    private DinheiroApi dinheiro;

    public DinheiroPagamento(DinheiroApi dinheiro){
        this.dinheiro = dinheiro;
    }

    @Override
    public void pagar(double valor){
        dinheiro.receberDinheiro(valor);
    }
}
