package Hamburgueria.PedidoComposto;

public class Fritas implements ItemPedido{

    @Override
    public String getNome(){
        return "Batata-Frita G";
    }
    @Override
    public double getPreco(){
        return 11.5;
    }
}
