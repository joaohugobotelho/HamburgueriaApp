package Hamburgueria.Notificando;
import java.util.List;
import java.util.ArrayList;



public class ReceberPedido {

    private List<Notificar> notifica = new ArrayList<>();

    public void adicionarNotificacao(
            Notificar notificar){

        notifica.add(notificar);
    }
    public void criarPedido() {
        notificarPedido(
                "Novo pedido recebido."
        );
    }

    private void notificarPedido(
            String mensagem){

        for(Notificar notificar : notifica){
            notificar.atualizar(mensagem);
        }
    }
}
