

public class ContaEspecial extends Conta {
    
    private final String tipo = "Especial";
    private double limite;

    public ContaEspecial(int numero, Cliente cliente, double limite) {
        super(numero, cliente);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor > 0 && valor <= this.getSaldo()+this.limite) {
            if(valor > this.getSaldo()){
                double limite;
                limite = valor - this.getSaldo();
                super.sacar(valor);
                this.limite -= limite;
                return true;    
            }
            super.sacar(valor);
            return true;
        }
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString()+"Limite: "+getLimite()+"\nTipo da conta: "+getTipo()+"\n\n";
    }

    @Override
    public boolean depositar(double valor) {
        if(this.getSaldo() < 0) {
            double deposito;
            if(this.getSaldo() + valor < 0) {
                this.limite += valor; 
                return super.depositar(valor);       
            }
            deposito = this.getSaldo() + valor;
            this.limite += deposito;
            return super.depositar(valor);    
        }
        return super.depositar(valor);
    }
}
