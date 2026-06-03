package Hamburgueria.EstadoPedidos;

public class SaiuPraEntrega implements EstadoPedido{

    @Override
    public String getEstado(){
        return "Pedido saiu pra entrega.";
    }
}
