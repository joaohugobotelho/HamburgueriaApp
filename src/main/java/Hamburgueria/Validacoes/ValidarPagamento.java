package Hamburgueria.Validacoes;

public class ValidarPagamento extends Validador{
    @Override
    public String validar(PedidoValidacao pedido) {
        if(!pedido.isPagamentoAprovado()){
            return "Pagamento recusado";
        }
        if (proximo != null){
            return proximo.validar(pedido);
        }
        return "Pedido aprovado";
    }
}
