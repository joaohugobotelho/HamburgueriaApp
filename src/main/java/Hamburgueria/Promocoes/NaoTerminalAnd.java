package Hamburgueria.Promocoes;

public class NaoTerminalAnd implements  Expressao{

    private Expressao esquerda;
    private Expressao direita;

    public NaoTerminalAnd(Expressao esquerda, Expressao direita){
        this.esquerda =esquerda;
        this.direita = direita;
    }

    @Override
    public boolean interpretar(ClientePromocao clientePromocao){
        return esquerda.interpretar(clientePromocao)
                &&
                direita.interpretar(clientePromocao);
    }
}
