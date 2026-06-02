package Hamburgueria.HamburguerPersonalizado;

// BUILDER

public class MonteHamburguer {

   private boolean hamburguer;
   private boolean queijo;
   private boolean bacon;
   private boolean ovo;
   private boolean alface;
   private boolean tomate;
   private boolean ketchup;
   private boolean maionese;
   private boolean pao;


   public MonteHamburguer comQueijo(){
       queijo = true;
       return this;
   }
    public MonteHamburguer comHamburguer(){
        hamburguer = true;
        return this;
    }
   public MonteHamburguer comBacon(){
       bacon = true;
       return this;
   }
   public MonteHamburguer comOvo(){
       ovo = true;
       return this;
   }
   public MonteHamburguer comAlface(){
       alface = true;
       return this;
   }
   public MonteHamburguer comTomate(){
       tomate = true;
       return this;
   }
   public MonteHamburguer comKetchup(){
       ketchup = true;
       return this;
   }
   public MonteHamburguer comMaionese(){
       maionese = true;
       return this;
   }
   public MonteHamburguer comPao(){
       pao = true;
       return this;
   }

   public PersonalizarHamburguer build(){
       return new PersonalizarHamburguer(
               hamburguer,
               queijo,
               ketchup,
               maionese,
               bacon,
               ovo,
               alface,
               tomate,
               pao);
   }


}
