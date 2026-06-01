package Hamburgueria.Hamburguer;

public class FabricaXBurguer extends FabricaHamburguer{
    @Override
    public Hamburguer criarHamgurguer() {
        return new XBurguer();
    }
}
