package Hamburgueria.Comandos;

public class ComandoCancelarPedido implements Comando{

    private PedidoComando pedidoComando;

    public ComandoCancelarPedido( PedidoComando pedidoComando){
        this.pedidoComando = pedidoComando;
    }
    @Override
    public  void executar(){
        pedidoComando.cancelarPedido();
    }
}
