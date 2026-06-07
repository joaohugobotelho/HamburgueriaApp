package Hamburgueria.AdicionaExtras;

public class BurguerBase implements Extra{
    @Override
    public String getDescricao(){
        return "X-Burguer";
    }
    @Override
    public double getPreco(){
        return 15.00;
    }
}
