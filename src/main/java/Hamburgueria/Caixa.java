package Hamburgueria;

public class Caixa {

    private static Caixa instance;

    private double saldo;

    private Caixa() {
        saldo = 0;
    }

    public static Caixa getInstance() {

        if (instance == null) {
            instance = new Caixa();
        }

        return instance;
    }

    public void adicionarValor(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}