package Hamburgueria.Descontos;

public class Pedidos {

    private double valor;
    private DescontosInterface desconto;

    public Pedidos( double valor, DescontosInterface desconto){

        this.valor = valor;
        this.desconto = desconto;
    }

    public double getValorFinal(){
        return desconto.calcularDesconto(valor);
    }
}
