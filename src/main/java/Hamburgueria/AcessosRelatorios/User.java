package Hamburgueria.AcessosRelatorios;

public class User {
    private String nome;
    private boolean gerente;

    public User(String nome, boolean gerente){
        this.nome = nome;
        this. gerente = gerente;
    }

    public boolean isGerente(){
        return gerente;
    }
   public String getNome(){
        return nome;
   }
}
