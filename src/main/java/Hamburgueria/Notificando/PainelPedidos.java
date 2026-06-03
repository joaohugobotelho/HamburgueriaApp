package Hamburgueria.Notificando;

public class PainelPedidos implements Notificar{

    private String utlimaMensagem;

    @Override
    public void atualizar( String mensagem){
        utlimaMensagem = mensagem;
    }

    public String getUtlimaMensagem(){
        return utlimaMensagem;
    }
}
