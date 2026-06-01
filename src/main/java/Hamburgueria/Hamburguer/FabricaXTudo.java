package Hamburgueria.Hamburguer;

public class FabricaXTudo extends FabricaHamburguer{

    @Override
    public Hamburguer criarHamgurguer() {
        return new XTudo();
    }
}
