package Hamburgueria.Comandos;

public class ComandoRealizarPedido implements Comando{

    private PedidoComando pedidoComando;

    public ComandoRealizarPedido( PedidoComando pedidoComando){
        this.pedidoComando = pedidoComando;
    }

    @Override
    public void executar(){
        pedidoComando.realizarPedido();
    }
}
