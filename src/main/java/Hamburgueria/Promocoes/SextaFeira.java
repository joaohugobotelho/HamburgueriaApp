package Hamburgueria.Promocoes;

public class SextaFeira implements Expressao{
    @Override
    public boolean interpretar(ClientePromocao clientePromocao){
        return clientePromocao.isSextaFeira();
    }
}
