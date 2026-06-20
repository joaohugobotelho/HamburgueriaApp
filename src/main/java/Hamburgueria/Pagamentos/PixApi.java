package Hamburgueria.Pagamentos;

public class PixApi {
    private double ultimoPagamento;

    public void realizarPix(double valor){
        ultimoPagamento = valor;
    }

    public double getUltimoPagamento(){
        return ultimoPagamento;
    }
}
