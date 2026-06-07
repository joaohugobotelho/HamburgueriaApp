package Hamburgueria.AdicionaExtras;

public class CalabresaExtra extends IngredientesExtras{
    public CalabresaExtra(Extra extra){
        super(extra);
    }

    @Override
    public String getDescricao(){
        return extra.getDescricao() + " + Calabresa Extra";
    }

    @Override
   public double getPreco(){
        return extra.getPreco() + 4.5;
    }
}
