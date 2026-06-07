package Hamburgueria;

import static org.junit.jupiter.api.Assertions.*;

import Hamburgueria.AdicionaExtras.BaconExtra;
import Hamburgueria.AdicionaExtras.BurguerBase;
import Hamburgueria.AdicionaExtras.Extra;
import Hamburgueria.AdicionaExtras.QueijoExtra;
import Hamburgueria.Combos.Combo;
import Hamburgueria.Combos.ComboPremium;
import Hamburgueria.Combos.ComboPromocional;
import Hamburgueria.Combos.ComboTradicional;
import Hamburgueria.Descontos.ClienteFrequente;
import Hamburgueria.Descontos.DescontoSextaFeira;
import Hamburgueria.Descontos.Pedidos;
import Hamburgueria.EstadoPedidos.*;
import Hamburgueria.Hamburguer.FabricaXBacon;
import Hamburgueria.Hamburguer.FabricaXBurguer;
import Hamburgueria.Hamburguer.FabricaXSalada;
import Hamburgueria.Hamburguer.FabricaXTudo;
import Hamburgueria.Hamburguer.Hamburguer;


import Hamburgueria.HamburguerPersonalizado.MonteHamburguer;
import Hamburgueria.HamburguerPersonalizado.PersonalizarHamburguer;
import Hamburgueria.Notificando.Cozinha;
import Hamburgueria.Notificando.Notificar;
import Hamburgueria.Notificando.PainelPedidos;
import Hamburgueria.Notificando.ReceberPedido;
import org.junit.jupiter.api.Test;
public class HamburgueriaTest {

    @Test
    public void deveRetornarMesmaInstancia() {

        Caixa caixa1 = Caixa.getInstance();
        Caixa caixa2 = Caixa.getInstance();

        assertSame(caixa1, caixa2);
    }

    @Test
    public void deveAdicionarValorAoCaixa() {

        Caixa caixa = Caixa.getInstance();

        double saldoInicial = caixa.getSaldo();

        Pedido pedido = new Pedido("João", 50.0);

        pedido.finalizarPedido();

        assertEquals(
                saldoInicial + 50.0,
                caixa.getSaldo(),
                0.01
        );
    }

    // factory method test
    @Test
    public void deveCriarHamburgueres() {

        Hamburguer xBurguer =
                new FabricaXBurguer().criarHamgurguer();

        Hamburguer xSalada =
                new FabricaXSalada().criarHamgurguer();

        Hamburguer xBacon =
                new FabricaXBacon().criarHamgurguer();

        Hamburguer xTudo =
                new FabricaXTudo().criarHamgurguer();

        assertEquals("X-Burguer", xBurguer.getNome());
        assertEquals("X-Salada", xSalada.getNome());
        assertEquals("X-Bacon", xBacon.getNome());
        assertEquals("X-Tudo", xTudo.getNome());
    }

    // abstract factory test
    @Test
    public void deveCriarComboTradicional() {

        Combo combo =
                new ComboTradicional();

        assertEquals(
                "X-Bacon",
                combo.criarHamburguer().getNome()
        );

        assertEquals(
                "Batata Frita",
                combo.criarEntrada().getNome()
        );

        assertEquals(
                "Coca-cola",
                combo.criarBebida().getNome()
        );
        assertEquals("Sorvete",
                combo.criarSobremesa().getNome()
        );
    }
    @Test
    public void deveCriarComboPremium(){

        Combo combo = new ComboPremium();

        assertEquals("X-Tudo",
                combo.criarHamburguer().getNome()
        );
        assertEquals("Onion Rings",
                combo.criarEntrada().getNome()
        );
        assertEquals("Milk Shake",
                combo.criarBebida().getNome()
        );
        assertEquals("Pudim",
                combo.criarSobremesa().getNome()
        );
    }
    @Test
    public void deveCriarComboPromocional(){

        Combo combo = new ComboPromocional();

        assertEquals("X-Salada",
                combo.criarHamburguer().getNome()
        );
        assertEquals("Nuggets",
                combo.criarEntrada().getNome()
        );
        assertEquals("Suco de Laranja",
                combo.criarBebida().getNome()
        );
        assertEquals("Brownie",
                combo.criarSobremesa().getNome()
        );
    }

    //BUILDER TEST
    @Test
    public void deveMontarHamburguerPersonalizado(){

        PersonalizarHamburguer hamburguer =
                new MonteHamburguer()
                        .comHamburguer()
                        .comPao()
                        .comBacon()
                        .comOvo()
                        .comQueijo()
                        .comAlface()
                        .comTomate()
                        .comKetchup()
                        .comMaionese()
                        .build();

        assertTrue(hamburguer.temHamburguer());
        assertTrue(hamburguer.temAlface());
        assertTrue(hamburguer.temTomate());
        assertTrue(hamburguer.temPao());
        assertTrue(hamburguer.temBacon());
        assertTrue(hamburguer.temOvo());
        assertTrue(hamburguer.temQueijo());
        assertTrue(hamburguer.temMaionese());
        assertTrue(hamburguer.temKetchup());

    }

    // STRATEGY TESTS USADO PARA DESCONTOS

    @Test
    public void deveAplicarDescontoClienteFrequente10(){ // 10 pedidos+

        Pedidos pedidos = new Pedidos(100.0, new ClienteFrequente(10));

        assertEquals(80.0, pedidos.getValorFinal(),0.01);
    }

    @Test
    public void deveAplicarDescontoClienteFrequente5(){  //5 pedidos+
        Pedidos pedidos = new Pedidos(100.0, new ClienteFrequente(5));

        assertEquals(85.0, pedidos.getValorFinal(), 0.01);
    }
    @Test
    public void deveAplicarDescontoSextaFeira(){
        Pedidos pedidos = new Pedidos(100.0, new DescontoSextaFeira());
        assertEquals(95.0, pedidos.getValorFinal());
    }

    // TEST OBSERVER
    @Test
    public void deveNotificarCozinhaPainel(){

        ReceberPedido pedido = new ReceberPedido();

        Cozinha cozinha = new Cozinha();

        PainelPedidos painel = new PainelPedidos();

        pedido.adicionarNotificacao(cozinha);

        pedido.adicionarNotificacao(painel);

        pedido.criarPedido();

        assertEquals("Novo pedido recebido.", cozinha.getUltimaMensagem());

        assertEquals("Novo pedido recebido.", painel.getUtlimaMensagem());
    }

    // TEST STATE

    // pedido recebido

    @Test
    public void deveIniciarRecebido(){

        PedidoEstado pedido = new PedidoEstado();

        assertEquals("Recebido.", pedido.getEstado());
    }

    // pedido em preparo

    @Test
    public void deveIniciarPreparo(){

        EmPreparo preparo = new EmPreparo();

        assertEquals("Pedido sendo preparado.", preparo.getEstado());
    }

    // pedido pronto
    @Test
    public void deveFicarPronto(){
        PedidoPronto pronto = new PedidoPronto();

        assertEquals("Pedido pronto.", pronto.getEstado());
    }

    // pedido saiu pra entrega
    @Test
    public void deveSairEntrega(){
        SaiuPraEntrega entrega = new SaiuPraEntrega();

        assertEquals("Pedido saiu pra entrega.", entrega.getEstado());
    }

    // pedido entregue
    @Test
    public void deveEntregar(){
        PedidoEntregue entregue = new PedidoEntregue();

        assertEquals("Pedido entregue.", entregue.getEstado());
    }

    // DECORATOR TEST


    // extra de bacon
    @Test
    public void deveAdicionarBacon(){

        Extra extra = new BaconExtra(new BurguerBase());

        assertEquals(19.0, extra.getPreco(), 0.01);
    }

    // extra de queijo
    @Test
    public void deveAdicionarQueijo(){

        Extra extra = new QueijoExtra(new BurguerBase());

        assertEquals(18.0, extra.getPreco(), 0.01);
    }
}



