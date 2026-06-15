package Hamburgueria.ReutilizacaoObjetos;
import java.util.HashMap;
import java.util.Map;


public class FabricaIngredientes {
    private static  Map<String, ReutilizaIngredientes> ingredientes = new HashMap<>();

    public static ReutilizaIngredientes getInredientes(String nome){

        ReutilizaIngredientes ingrediente = ingredientes.get(nome);

        if(ingrediente == null){
            ingrediente = new ReutilizaIngredientes(nome);
        }
        ingredientes.put(nome, ingrediente);
        return ingrediente;
    }


}
