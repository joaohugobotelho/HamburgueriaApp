package Hamburgueria.Iterator;

import java.util.List;

public class IteratorPedido implements Iterator{

    private List<Item> itens;

    private int posicao = 0;

    public IteratorPedido(List<Item> itens){
        this.itens = itens;
    }

    @Override
    public boolean temProximo(){
        return posicao < itens.size();
    }

    @Override
    public Item proximo(){
        return itens.get(posicao++);
    }
}
