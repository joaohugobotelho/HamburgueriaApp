package Hamburgueria.Notificando;

public class Cozinha implements Notificar{

    private String ultimaMensagem;

    @Override
    public void atualizar( String mensagem){
        ultimaMensagem = mensagem;
    }

    public String getUltimaMensagem(){
        return ultimaMensagem;
    }
}
