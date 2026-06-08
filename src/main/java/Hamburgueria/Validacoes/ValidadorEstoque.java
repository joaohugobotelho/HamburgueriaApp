package Hamburgueria.Validacoes;

public class ValidadorEstoque extends Validador{

    @Override
    public String validar(PedidoValidacao pedido){
        if (!pedido.isEstoqueDisponivel()) {
            return "Produto sem estoque";
        }
        if(proximo != null){
            return proximo.validar(pedido);
        }
        return "Pedido aprovado";
    }
}
