package Hamburgueria.Comunicacao;

import java.util.ArrayList;
import java.util.List;

public class ComunicaHamburgueria implements Comunica {

    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario usuario){
        for(Usuario u : usuarios){
            if(u != usuario ){
                u.receber(mensagem);
            }
        }
    }
}
