package Hamburgueria.Validacoes;

public abstract class Validador {

    protected Validador proximo;

    public void setProximo(Validador proximo){
        this.proximo = proximo;
    }

    public abstract String validar(PedidoValidacao pedido);
}
