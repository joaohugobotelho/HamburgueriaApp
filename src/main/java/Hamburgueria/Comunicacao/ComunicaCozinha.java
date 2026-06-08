package Hamburgueria.Comunicacao;

import Hamburgueria.Notificando.Cozinha;

public class ComunicaCozinha extends Usuario{
    public  ComunicaCozinha(Comunica comunica, String nome){
        super(comunica, nome);
    }

    @Override
    public void receber(String mensagem){
        ultimaMensagem = mensagem;
    }
}
