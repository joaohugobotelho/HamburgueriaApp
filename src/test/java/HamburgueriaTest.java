package Hamburgueria;

import static org.junit.jupiter.api.Assertions.*;

import Hamburgueria.AdicionaExtras.*;
import Hamburgueria.Comandos.Atendente;
import Hamburgueria.Comandos.ComandoCancelarPedido;
import Hamburgueria.Comandos.ComandoRealizarPedido;
import Hamburgueria.Comandos.PedidoComando;
import Hamburgueria.Combos.Combo;
import Hamburgueria.Combos.ComboPremium;
import Hamburgueria.Combos.ComboPromocional;
import Hamburgueria.Combos.ComboTradicional;
import Hamburgueria.Comunicacao.ComunicaCozinha;
import Hamburgueria.Comunicacao.ComunicaEntregador;
import Hamburgueria.Comunicacao.ComunicaHamburgueria;
import Hamburgueria.CopiaItensCardapio.CopiaBurguer;
import Hamburgueria.Descontos.ClienteFrequente;
import Hamburgueria.Descontos.DescontoSextaFeira;
import Hamburgueria.Descontos.Pedidos;
import Hamburgueria.EstadoPedidos.*;
import Hamburgueria.EtapaLanches.PrepararLanches;
import Hamburgueria.EtapaLanches.PrepararXBacon;
import Hamburgueria.EtapaLanches.PrepararXTudo;
import Hamburgueria.Hamburguer.FabricaXBacon;
import Hamburgueria.Hamburguer.FabricaXBurguer;
import Hamburgueria.Hamburguer.FabricaXSalada;
import Hamburgueria.Hamburguer.FabricaXTudo;
import Hamburgueria.Hamburguer.Hamburguer;


import Hamburgueria.HamburguerPersonalizado.MonteHamburguer;
import Hamburgueria.HamburguerPersonalizado.PersonalizarHamburguer;
import Hamburgueria.Iterator.Item;
import Hamburgueria.Iterator.Iterator;
import Hamburgueria.Iterator.PedidoIterator;
import Hamburgueria.Notificando.Cozinha;
import Hamburgueria.Notificando.PainelPedidos;
import Hamburgueria.Notificando.ReceberPedido;
import Hamburgueria.Pagamentos.*;
import Hamburgueria.PedidoComposto.*;
import Hamburgueria.AcessosRelatorios.AcessoRelatorio;
import Hamburgueria.AcessosRelatorios.User;
import Hamburgueria.Promocoes.*;
import Hamburgueria.ReutilizacaoObjetos.FabricaIngredientes;
import Hamburgueria.ReutilizacaoObjetos.ReutilizaIngredientes;
import Hamburgueria.Sistema.SistemaPedido;
import Hamburgueria.Validacoes.PedidoValidacao;
import Hamburgueria.Validacoes.ValidadorEstoque;
import Hamburgueria.Validacoes.ValidadorPedido;
import Hamburgueria.Validacoes.ValidarPagamento;
import Hamburgueria.VisitarItem.Bebida;
import Hamburgueria.VisitarItem.Burguer;
import Hamburgueria.VisitarItem.RelatorioPreco;
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

    //extra calabresa
    @Test
    public void deveAdicionarCalabresa(){

        Extra extra = new CalabresaExtra(new BurguerBase());

        assertEquals(19.50, extra.getPreco(), 0.01);
    }

    //PREPARAR LANCHES TEMPLATE METHOD xbacon e xtudo exemplo

    @Test
    public void devePrepararXBacon(){
        PrepararLanches lanche = new PrepararXBacon();
        assertTrue(lanche.preparar().contains("Bacon e Queijo"));
    }
    @Test
    public void devePrepararXTudo(){
        PrepararXTudo lanche = new PrepararXTudo();
        assertTrue(lanche.preparar().contains("Bacon, ovo, queijo, frango, calabresa, presunto, molho e salada"));
    }

    // TEST MEDIATOR

    @Test
    public void deveEnviarMensagemProsUsuarios(){
        ComunicaHamburgueria comunica = new ComunicaHamburgueria();

        ComunicaCozinha cozinha = new ComunicaCozinha(comunica, "Cozinha");

        ComunicaEntregador entregador = new ComunicaEntregador(comunica, "João");
        comunica.adicionarUsuario(cozinha);
        comunica.adicionarUsuario(entregador);
        cozinha.enviar("Pedido pronto");
        assertEquals("Pedido pronto", entregador.getUltimaMensagem());

    }

    // TEST COMPOSITE DE UM PEDIDO COMPLETO

    @Test
    public void deveSomarPedidoCompleto(){
        TotalPedido pedido = new TotalPedido();
        pedido.adicionar(new Xburguer());
        pedido.adicionar(new Fritas());
        pedido.adicionar((new Refrigerante()));
        pedido.adicionar(new Churros());
    }

    //TEST COMPOSITE DE UM BURGUER E BATATA

    @Test
    public void deveSomarXburguerFritas(){
        TotalPedido pedido = new TotalPedido();
        pedido.adicionar(new Xburguer());
        pedido.adicionar(new Fritas());
    }

    // TEST DO FAÇADE VERIFICANDO ESTOQUE. PEDIDO, PAGAMENTO E ENTREGA
    @Test
    public void deveRealizarPedidoCompleto(){

        SistemaPedido sistema = new SistemaPedido();
        String resultado = sistema.realizarPedido();
        assertTrue(resultado.contains("Estoque verificado"));
        assertTrue(resultado.contains("Pagamento aprovado"));
        assertTrue(resultado.contains("Pedido sendo preparado"));
        assertTrue(resultado.contains("Entrega gerada"));
    }

    //TEST CHAIN OF RESPONSABILITY
    // PEDIDO APROVADO
    @Test
    public void deveAprovarPedido() {
        PedidoValidacao pedido = new PedidoValidacao(true, true, true);
        ValidadorPedido pedidoVal = new ValidadorPedido();
        ValidadorEstoque estoqueVal = new ValidadorEstoque();
        ValidarPagamento pagamentoVal = new ValidarPagamento();

        pedidoVal.setProximo(estoqueVal);
        estoqueVal.setProximo(pagamentoVal);
        assertEquals("Pedido aprovado", pedidoVal.validar(pedido));
    }

    //TEST SEM ESTOQUE DISPONIVEL
    @Test
    public void deveRecusarPorFaltaEstoque(){
        PedidoValidacao pedido = new PedidoValidacao(true, false,true);
        ValidadorPedido pedidoVal = new ValidadorPedido();
        ValidadorEstoque estoqueVal = new ValidadorEstoque();
        ValidarPagamento pagamentoVal = new ValidarPagamento();

        pedidoVal.setProximo(estoqueVal);
        estoqueVal.setProximo(pagamentoVal);
        assertEquals("Produto sem estoque", pedidoVal.validar(pedido));
    }

    // TEST PAGAMENTO RECUSADO
    @Test
    public void devePagamentoRecusado(){
        PedidoValidacao pedido = new PedidoValidacao(true, true, false);
        ValidadorPedido pedidoVal = new ValidadorPedido();
        ValidadorEstoque estoqueVal = new ValidadorEstoque();
        ValidarPagamento pagamentoVal = new ValidarPagamento();

        pedidoVal.setProximo(estoqueVal);
        estoqueVal.setProximo(pagamentoVal);
        assertEquals("Pagamento recusado", pedidoVal.validar(pedido));
    }

    //TEST ITERATOR

    // TESTE 1 PERCORRENDO PEDIDO

    @Test
    public void devePercorrerPedido(){
        PedidoIterator pedido = new PedidoIterator();
        pedido.adicionarItem( new Item("X-Burguer"));

        pedido.adicionarItem(new Item("Batata-Frita"));

        Iterator iterator = pedido.criarIterator();
        assertEquals("X-Burguer", iterator.proximo().getNome());
        assertEquals("Batata-Frita", iterator.proximo().getNome());
    }

    //TEST 2 VERIFICA SE TEM UM PROXIMO ITEM

    @Test
    public void deveVerificarSeTemProximo(){

        PedidoIterator pedido = new PedidoIterator();
        pedido.adicionarItem( new Item("Guaraná"));

        Iterator iterator = pedido.criarIterator();
        assertTrue(iterator.temProximo());

        iterator.proximo();
        assertFalse(iterator.temProximo());
    }

    //TEST PADRAO PROTOTYPE

    @Test
    public void deveClonarHamburguer(){
        CopiaBurguer original = new CopiaBurguer("X-Tudo", 25.00);

        CopiaBurguer copia = (CopiaBurguer) original.clonar();
        assertEquals(original.getNome(), copia.getNome());
        assertEquals(original.getPreco(), copia.getPreco());
        assertNotSame(original, copia);
    }

    // TEST PADRAO FLYWEIGHT

    @Test
    public void deveReutilizarIngrediente(){
        ReutilizaIngredientes pao1 = FabricaIngredientes.getInredientes("Pão");

        ReutilizaIngredientes pao2 = FabricaIngredientes.getInredientes("Pão");

        assertSame(pao1, pao2);
    }
    @Test
    public void deveCriarIngredientesDiferentes(){
        ReutilizaIngredientes pao = FabricaIngredientes.getInredientes("Pão");

        ReutilizaIngredientes queijo = FabricaIngredientes.getInredientes("Queijo");

        assertNotSame(pao, queijo);
    }

    //TEST PADRAO VISITOR

    @Test
    public void deveSomarprecos(){
        Burguer burguer = new Burguer("X-Bacon", 18.0);
        Bebida bebida = new Bebida("Guaraná", 6.0);

        RelatorioPreco relatorio = new RelatorioPreco();
        burguer.aceitar(relatorio);
        bebida.aceitar(relatorio);
        assertEquals(24.0, relatorio.getTotal(),0.01);
    }

    //TEST PADRAO COMMAND

    //TEST 1 REALIZA O PEDIDO E VERIFICA O STATUS

    @Test
    public void deveRealizarPedido(){
        PedidoComando pedidoComando = new PedidoComando();

        ComandoRealizarPedido comandoRealizarPedido = new ComandoRealizarPedido(pedidoComando);

        pedidoComando.realizarPedido();

        assertEquals("Pedido realizado.", pedidoComando.getStatus());
    }

    // TEST 2 CANCELA O PEDIDO E VERIFICA O STATUS

    @Test
    public void deveCancelarPedido(){

        PedidoComando pedidoComando = new PedidoComando();

        ComandoCancelarPedido comandoCancelarPedido = new ComandoCancelarPedido(pedidoComando);

        pedidoComando.cancelarPedido();
        assertEquals("Pedido cancelado.", pedidoComando.getStatus());
    }

    // TEST 3 - EXECUTA O COMANDO UTILIZANDO O ATENDENTE

    @Test
    public void deveExecutarComandoPeloAtendente(){

        PedidoComando pedidoComando = new PedidoComando();

        Atendente atendente = new Atendente();

        atendente.setComando(new ComandoRealizarPedido(pedidoComando));

        atendente.executarComando();

        assertEquals("Pedido realizado.", pedidoComando.getStatus());

    }

    // TEST DO PADRAO PROXY

    //TEST 1 = nega o acesso caso o user for funcionario

    @Test
    public void deveNegarAcessoFuncionario(){
        User user = new User("João", false);

        AcessoRelatorio acessoRelatorio = new AcessoRelatorio(user);
        assertEquals("Acesso negado.", acessoRelatorio.visualizar());
    }

    //TEST 2 VERIFICA SE O USER É O GERENTE

    @Test
    public void devePermitirAcessoGerente(){
        User user = new User("Hugo", true);

        AcessoRelatorio acessoRelatorio = new AcessoRelatorio(user);
        assertEquals("Faturamento: R$ 50.000",acessoRelatorio.visualizar());
    }


    // TEST PADRAO ADAPTER

    // TEST REALAIZA O PAGAMENTO VIA PIX

    @Test
    public void deveRealizarPagamentoPix(){

        PixApi pixApi = new PixApi();

        Pagamento pagamento = new PixPagamento(pixApi);

        pagamento.pagar(50.0);
        assertEquals(50.0, pixApi.getUltimoPagamento());
    }

    // TEST 2 - PAGAMENTO VIA CARTAO

    @Test
    public void devePagarComCartao(){
        CartaoApi cartao = new CartaoApi();

        Pagamento pagamento = new CartaoPagamento(cartao);

        pagamento.pagar(70.0);

        assertEquals(70.0, cartao.ultimoPagamento,0.01);
    }

    // TEST 3 - VERIFICA O PAGAMENTO DINHEIRO

    @Test
    public void devePagarComDinheiro(){
        DinheiroApi dinheiro = new DinheiroApi();

        Pagamento pagamento = new DinheiroPagamento(dinheiro);

        pagamento.pagar(28.0);
        assertEquals(28.0, dinheiro.ultimoPagamento, 0.01);
    }


    //TEST PADRAO INTERPRETER

    //TEST 1 VERIFICA SE O CLIENTE E FREQUENTE E É SEXTA FEIRA

    @Test
    public void deveAplicarPromocao(){

        ClientePromocao cliente = new ClientePromocao(true, true);

        Expressao promocao = new FrequenteEDiaPromocao(new ClienteFrequencia(), new SextaFeira());

        assertTrue(promocao.interpretar(cliente));
    }

    //TEST 2 - VERIFICA SE É ALGUM OUTRO DIA

    @Test
    public void naoDeveAplicarPromocao(){
        ClientePromocao cliente = new ClientePromocao(true, false);

        Expressao promocao = new FrequenteEDiaPromocao(new ClienteFrequencia(), new SextaFeira());
    }
}



