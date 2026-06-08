package Hamburgueria.PedidoComposto;

import java.util.ArrayList;
import java.util.List;

public class TotalPedido implements ItemPedido{

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionar(ItemPedido item) {
        itens.add(item);
    }
    @Override
    public String getNome(){
        return "Pedido";
    }
    @Override
    public double getPreco(){
        double total = 0;
        for(ItemPedido item : itens){
            total += item.getPreco();
        }
        return total;
    }

}
