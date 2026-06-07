package Hamburgueria.AdicionaExtras;

import Hamburgueria.Hamburguer.Hamburguer;

public class BaconExtra extends IngredientesExtras{

    public BaconExtra(Extra extra){
        super(extra);
    }

    @Override
    public String getDescricao() {
        return extra.getDescricao()
                + " + Bacon";
    }

    @Override
    public double getPreco(){
        return extra.getPreco() + 4.0;
    }

}
