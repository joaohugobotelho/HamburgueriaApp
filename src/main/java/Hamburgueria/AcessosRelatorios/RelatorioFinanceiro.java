package Hamburgueria.AcessosRelatorios;

public class RelatorioFinanceiro implements Relatorio{
    @Override
    public String visualizar(){
        return "Faturamento: R$ 50.000";
    }
}
