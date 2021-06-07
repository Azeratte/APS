
public abstract class Conta {
    private int numero;

    private double saldo;

    private Cliente cliente;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean sacar(double valor) {
        if(valor > 0) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor) {
        if(valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Conta: "+this.numero+"\nSaldo R$ "+this.saldo+"\nNome: "+this.cliente.getNome()+"\n";
    }

    public void debitar(double valor) {
        if(valor >0 && valor <= this.saldo){
            this.saldo -= valor;
        }
    }

}