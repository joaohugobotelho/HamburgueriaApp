package Hamburgueria.Comandos;

public class Atendente {

    private Comando comando;

    public void setComando( Comando comando ){
        this.comando = comando;
    }

    public void executarComando(){
        comando.executar();
    }
}
