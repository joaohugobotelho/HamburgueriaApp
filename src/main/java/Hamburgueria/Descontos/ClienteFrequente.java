package Hamburgueria.Descontos;

public class ClienteFrequente implements DescontosInterface{

      private int quantidadePedidos;

      public ClienteFrequente ( int quantidadePedidos) {
          this.quantidadePedidos = quantidadePedidos;
      }

      @Override
      public double calcularDesconto( double valor ){
        if (quantidadePedidos >= 10){
            return valor * 0.80; // 20% de desconto em 10 pedidos+
        }
        if(quantidadePedidos >= 5){
            return valor * 0.85; //15% de desconto em 5 pedidos+
        }

        return valor;
      }
  }

