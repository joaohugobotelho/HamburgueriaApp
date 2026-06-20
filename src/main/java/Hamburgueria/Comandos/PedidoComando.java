package Hamburgueria.Comandos;

public class PedidoComando {

    private String status;

    public void realizarPedido(){
        status = "Pedido realizado.";
    }
    public void cancelarPedido(){
        status = "Pedido cancelado.";
    }
    public String getStatus(){
        return status;
    }
}
