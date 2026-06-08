package Hamburgueria.Comunicacao;

public abstract class Usuario {
    protected Comunica comunica;
    protected String nome;
    protected   String ultimaMensagem;

    public Usuario(Comunica comunica, String nome){
        this.comunica = comunica;
        this.nome = nome;
    }
    public void enviar(String mensagem){
        comunica.enviarMensagem(mensagem, this);
    }
    public abstract void receber(String mensagem);

    public String getUltimaMensagem(){
        return ultimaMensagem;
    }
}
