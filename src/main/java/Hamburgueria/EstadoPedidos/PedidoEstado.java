package Hamburgueria.EstadoPedidos;

public class PedidoEstado {

    private EstadoPedido estado;

    public PedidoEstado(){
        estado = new Recebido();
    }

    public void setEstado( EstadoPedido estado ){
        this.estado = estado;
    }

    public String getEstado(){
        return estado.getEstado();
    }
}
