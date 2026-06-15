package Hamburgueria.ReutilizacaoObjetos;
//PADRAO FLYWEIGHT


public class ReutilizaIngredientes {

    private String nome;

    public ReutilizaIngredientes(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}
