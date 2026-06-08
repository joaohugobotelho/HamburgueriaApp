package Hamburgueria.EtapaLanches; //TEMPLATE METHOD

public abstract class PrepararLanches {

    public final String preparar(){
        return prepararPao()+ adicionarCarne()+adicionarIngredientes()+embalar();
    }
    protected String prepararPao(){
        return "Oão preparado | ";
    }

    protected String adicionarCarne(){
        return "Carne Adicionada | ";
    }

    protected abstract String adicionarIngredientes();
    protected String embalar(){
        return "Lanche embalado";
    }


}
