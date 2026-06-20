package Hamburgueria.AcessosRelatorios;

public class AcessoRelatorio implements Relatorio{

    private User user;

    public AcessoRelatorio(User user){
        this.user = user;
    }

    @Override
    public String visualizar(){
        if (!user.isGerente()){
            return "Acesso negado.";
        }
        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        return relatorio.visualizar();
    }
}
