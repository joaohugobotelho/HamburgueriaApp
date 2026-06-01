package Hamburgueria.Combos;
import Hamburgueria.Bebidas.Bebidas;
import Hamburgueria.Bebidas.Refrigerante;
import Hamburgueria.Entradas.BatataFrita;
import Hamburgueria.Entradas.Entradas;
import Hamburgueria.Hamburguer.Hamburguer;
import Hamburgueria.Hamburguer.XBacon;
import Hamburgueria.Sobremesa.Sobremesa;
import Hamburgueria.Sobremesa.Sorvete;

public class ComboTradicional implements Combo{

    @Override
    public Hamburguer criarHamburguer(){
        return new XBacon();
    }

    @Override
    public Entradas criarEntrada(){
        return new BatataFrita();
    }

    @Override
    public Bebidas criarBebida(){
        return new Refrigerante();
    }

    @Override
    public Sobremesa criarSobremesa(){
        return new Sorvete();
    }
}
