package Hamburgueria.Combos;
import Hamburgueria.Hamburguer.Hamburguer;
import Hamburgueria.Entradas.Entradas;
import Hamburgueria.Bebidas.Bebidas;
import Hamburgueria.Sobremesa.Sobremesa;

// abstract factory

public interface Combo {

    Hamburguer criarHamburguer();
    Entradas criarEntrada();
    Bebidas criarBebida();
    Sobremesa criarSobremesa();
}
