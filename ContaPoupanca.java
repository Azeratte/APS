
public class ContaPoupanca extends Conta {

    private static double taxa = 0.015;
    private final String tipo = "Poupança";

    public ContaPoupanca(int numero, Cliente cliente) {
        super(numero, cliente);
    }

    public static double getTaxa() {
        return taxa;
    }

    public String getTipo() {
        return tipo;
    }

    public static void setTaxa(double taxa) {
        ContaPoupanca.taxa = taxa;
    }

    @Override
    public boolean sacar(double valor) {
        double valorTaxa = valor*ContaPoupanca.taxa; 
        if(valor <= this.getSaldo()+valorTaxa) {
            super.sacar(valor);
            super.debitar(valorTaxa);
            return true;
        }
        return false; 
    }

    @Override
    public String toString() {
        return super.toString()+"Tipo da conta: "+getTipo()+"\n\n";
    }
    
}