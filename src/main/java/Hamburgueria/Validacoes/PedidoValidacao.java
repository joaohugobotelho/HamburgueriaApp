package Hamburgueria.Validacoes;

// PADRAO CHAIN OF RESPONSIBILITY

public class PedidoValidacao {
    private boolean pedidoValido;
    private boolean estoqueDisponivel;
    private boolean pagamentoAprovado;

    public PedidoValidacao(boolean pedidoValido, boolean estoqueDisponivel, boolean pagamentoAprovado){
        this.pedidoValido = pedidoValido;
        this.estoqueDisponivel = estoqueDisponivel;
        this.pagamentoAprovado = pagamentoAprovado;
    }
    public boolean isPedidoValido(){
        return pedidoValido;
    }
    public boolean isEstoqueDisponivel(){
        return estoqueDisponivel;
    }

    public boolean isPagamentoAprovado() {
        return pagamentoAprovado;
    }
}
