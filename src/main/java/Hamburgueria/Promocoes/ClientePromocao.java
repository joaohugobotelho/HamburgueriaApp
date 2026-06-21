package Hamburgueria.Promocoes;

public class ClientePromocao {

    private boolean frequente;
    private boolean sextaFeira;

    public ClientePromocao(boolean frequente, boolean sextaFeira){
        this.frequente = frequente;
        this.sextaFeira = sextaFeira;
    }
    public boolean isFrequente(){
        return frequente;
    }

    public boolean isSextaFeira(){
        return sextaFeira;
    }
}
