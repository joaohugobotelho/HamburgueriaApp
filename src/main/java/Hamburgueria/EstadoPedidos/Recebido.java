package Hamburgueria.EstadoPedidos;

public class Recebido implements EstadoPedido{
    @Override
    public String getEstado(){
        return "Recebido";
    }
}
