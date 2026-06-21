package Hamburgueria.Promocoes;

public class ClienteFrequencia implements Expressao{

    @Override
    public boolean interpretar(ClientePromocao clientePromocao){
        return clientePromocao.isFrequente();
    }
}
