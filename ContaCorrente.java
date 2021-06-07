
public class ContaCorrente extends Conta {

    private final String tipo = "Corrente";
    
    public ContaCorrente(int numero, Cliente cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= this.getSaldo()) {
            super.sacar(valor);
            return true;
        } else {
        return false;
        }
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString()+"Tipo da conta: "+getTipo()+"\n\n";
    }
}
