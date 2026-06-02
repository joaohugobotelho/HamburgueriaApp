package Hamburgueria.Descontos;

public class DescontoSextaFeira implements DescontosInterface{

    @Override
    public double calcularDesconto( double valor ){
        return valor * 0.95; // 5% de desconto na sexta-feira
    }
}
