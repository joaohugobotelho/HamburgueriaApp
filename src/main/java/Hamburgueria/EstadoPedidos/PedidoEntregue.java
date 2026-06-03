package Hamburgueria.EstadoPedidos;

public class PedidoEntregue implements EstadoPedido{

    @Override
    public String getEstado(){
        return "Pedido entregue.";
    }
}
