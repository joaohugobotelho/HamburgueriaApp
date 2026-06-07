package Hamburgueria.AdicionaExtras;

public class QueijoExtra extends IngredientesExtras{
    public QueijoExtra(Extra extra) {
        super(extra);
    }

    @Override
    public String getDescricao(){
        return extra.getDescricao()+ " + Queijo Extra";
    }

    @Override
    public double getPreco(){
        return extra.getPreco() + 3.0;
    }
}
