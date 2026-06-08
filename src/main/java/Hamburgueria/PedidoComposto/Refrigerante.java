package Hamburgueria.PedidoComposto;

public class Refrigerante implements ItemPedido{

    @Override
    public String getNome(){
        return "Guaraná";
    }

    @Override
    public double getPreco(){
        return 6.0;
    }
}
