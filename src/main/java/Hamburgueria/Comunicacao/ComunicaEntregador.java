package Hamburgueria.Comunicacao;

import Hamburgueria.Entradas.Entradas;

public class ComunicaEntregador extends Usuario{

    public ComunicaEntregador(Comunica comunica, String nome){
        super(comunica, nome);
    }
    @Override
    public void receber(String mensagem){
        ultimaMensagem = mensagem;
    }
}
