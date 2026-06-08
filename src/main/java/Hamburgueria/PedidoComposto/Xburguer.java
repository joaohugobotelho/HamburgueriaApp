package Hamburgueria.PedidoComposto;

public class Xburguer implements ItemPedido{

    @Override
    public String getNome(){
        return "X-Burguer";
    }
    @Override
    public double getPreco(){
        return 15.0;
    }
}
