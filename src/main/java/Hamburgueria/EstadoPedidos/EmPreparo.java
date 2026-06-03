package Hamburgueria.EstadoPedidos;

public class EmPreparo implements EstadoPedido{

    @Override
    public String getEstado(){
        return  "Pedido sendo preparado.";
    }
}
