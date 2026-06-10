package Hamburgueria.Iterator;
import java.util.ArrayList;
import java.util.List;
public class PedidoIterator {

    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public Iterator criarIterator(){
        return new IteratorPedido(itens);
    }
}
