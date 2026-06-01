package Hamburgueria.Hamburguer;

public class FabricaXBacon extends FabricaHamburguer{

    @Override
    public Hamburguer criarHamgurguer() {
        return new XBacon();
    }
}
