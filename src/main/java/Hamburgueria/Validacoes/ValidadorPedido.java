package Hamburgueria.Validacoes;

public class ValidadorPedido  extends Validador{

    @Override
    public String validar(PedidoValidacao pedido){
        if(!pedido.isPedidoValido()){
            return "Pedido inválido";
        }
        if(proximo != null){
            return proximo.validar(pedido);
        }
        return "Pedido aprovado";
    }

}
