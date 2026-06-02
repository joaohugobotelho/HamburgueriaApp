package Hamburgueria.HamburguerPersonalizado;

public class PersonalizarHamburguer {

    private boolean queijo;
    private boolean bacon;
    private boolean ovo;
    private boolean hamburguer;
    private boolean alface;
    private boolean tomate;
    private boolean ketchup;
    private boolean maionese;
    private boolean pao;

    public PersonalizarHamburguer(
            boolean queijo,
            boolean ketchup,
            boolean maionese,
            boolean bacon,
            boolean ovo,
            boolean hamburguer,
            boolean alface,
            boolean tomate,
            boolean pao){

        this.hamburguer = hamburguer;
        this.queijo = queijo;
        this.bacon = bacon;
        this.ovo = ovo;
        this.alface = alface;
        this.tomate = tomate;
        this.ketchup = ketchup;
        this.maionese = maionese;
        this.pao = pao;
    }

    public boolean temQueijo(){
        return queijo;
    }
    public boolean temBacon(){
        return bacon;
    }
    public boolean temOvo(){
        return ovo;
    }
    public boolean temHamburguer(){
        return hamburguer;
    }

    public boolean temAlface(){
        return alface;
    }
    public boolean temTomate(){
        return tomate;
    }

    public boolean temKetchup(){
        return ketchup;
    }
    public boolean temMaionese(){
        return maionese;
    }
    public boolean temPao(){
        return pao;
    }
}
