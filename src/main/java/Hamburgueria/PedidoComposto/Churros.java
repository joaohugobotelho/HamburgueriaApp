package Hamburgueria.PedidoComposto;

public class Churros implements ItemPedido{

    @Override
    public String getNome(){
        return "Churros";
    }
    @Override
    public double getPreco(){
        return 8.0;
    }
}
