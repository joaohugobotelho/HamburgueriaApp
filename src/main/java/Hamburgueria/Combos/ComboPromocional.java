package Hamburgueria.Combos;

import Hamburgueria.Bebidas.Bebidas;
import Hamburgueria.Bebidas.Suco;
import Hamburgueria.Entradas.Entradas;
import Hamburgueria.Entradas.Nuggets;
import Hamburgueria.Hamburguer.Hamburguer;
import Hamburgueria.Hamburguer.XSalada;
import Hamburgueria.Sobremesa.Brownie;
import Hamburgueria.Sobremesa.Sobremesa;

public class ComboPromocional implements Combo{

    @Override
    public Hamburguer criarHamburguer(){
        return new XSalada();
    }

    @Override
    public Entradas criarEntrada(){
        return new Nuggets();
    }

    @Override
    public Bebidas criarBebida(){
        return new Suco();
    }

    @Override
    public Sobremesa criarSobremesa() {
        return new Brownie();
    }
}
