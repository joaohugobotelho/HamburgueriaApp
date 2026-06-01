package Hamburgueria.Combos;
import Hamburgueria.Bebidas.MilkShake;
import Hamburgueria.Entradas.OnionRing;
import Hamburgueria.Hamburguer.Hamburguer;
import Hamburgueria.Entradas.Entradas;
import Hamburgueria.Bebidas.Bebidas;
import Hamburgueria.Hamburguer.XTudo;
import Hamburgueria.Sobremesa.Sobremesa;
import Hamburgueria.Sobremesa.Pudim;


public class ComboPremium implements Combo{

    @Override
    public Hamburguer criarHamburguer(){
        return new XTudo();
    }

    @Override
    public Entradas criarEntrada(){
        return new OnionRing();
    }

    @Override
    public Bebidas criarBebida(){
        return new MilkShake();
    }

    @Override
    public Sobremesa criarSobremesa(){
        return new Pudim();
    }
}
