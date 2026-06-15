package Hamburgueria.CopiaItensCardapio;

public class CopiaBurguer implements CopiaPrototipo{


    private String nome;
    private double preco;

    public CopiaBurguer(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    @Override
    public CopiaPrototipo clonar(){

        return new CopiaBurguer(nome, preco);
    }
}
