package Hamburgueria.VisitarItem;

public class Bebida implements ItemCardapio{

    private String nome;
    private double preco;

    public Bebida(String nome, double preco){
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
    public void aceitar(Visitar visitar){
        visitar.visitarBebida(this);
    }
}
