package Hamburgueria.Pagamentos;

public class PixPagamento implements Pagamento{

    private PixApi pixApi;

    public PixPagamento(PixApi pixApi){
        this.pixApi = pixApi;
    }

    @Override
    public void pagar(double valor){
        pixApi.realizarPix(valor);
    }
}
