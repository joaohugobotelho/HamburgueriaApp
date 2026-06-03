package Hamburgueria.EstadoPedidos;

public class PedidoPronto implements EstadoPedido{

    @Override
    public String getEstado(){
        return "Pedido pronto.";
    }
}
