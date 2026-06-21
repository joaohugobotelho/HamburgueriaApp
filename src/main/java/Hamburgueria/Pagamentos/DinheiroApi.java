package Hamburgueria.Pagamentos;

public class DinheiroApi {
    public double ultimoPagamento;

    public void receberDinheiro(double valor){
        ultimoPagamento = valor;
    }
}
