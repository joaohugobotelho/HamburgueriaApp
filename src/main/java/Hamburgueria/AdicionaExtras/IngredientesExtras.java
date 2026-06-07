package Hamburgueria.AdicionaExtras;

import Hamburgueria.Hamburguer.Hamburguer;

public abstract class IngredientesExtras  implements Extra {

    protected Extra extra;

    public IngredientesExtras(Extra extra){
        this.extra = extra;    }
}
