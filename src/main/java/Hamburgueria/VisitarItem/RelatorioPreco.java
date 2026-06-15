package Hamburgueria.VisitarItem;

public class RelatorioPreco implements Visitar{

    private double total = 0;

    @Override
    public void visitarBurguer(Burguer burguer){
        total += burguer.getPreco();
    }

    @Override
    public void visitarBebida(Bebida bebida){
        total += bebida.getPreco();
    }

    public double getTotal(){
        return total;
    }
}
