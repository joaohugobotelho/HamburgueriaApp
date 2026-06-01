package Hamburgueria.Hamburguer;

public class FabricaXSalada extends FabricaHamburguer{
    @Override
    public Hamburguer criarHamgurguer() {
        return new XSalada();
    }
}
