package Hamburgueria.Promocoes;

public class FrequenteEDiaPromocao implements  Expressao{

    private Expressao esquerda;
    private Expressao direita;

    public FrequenteEDiaPromocao(Expressao esquerda, Expressao direita){
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
