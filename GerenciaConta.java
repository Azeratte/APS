import java.util.ArrayList;

public class GerenciaConta {
    private ArrayList<Conta> Gerencia;

    public GerenciaConta(){
        Gerencia = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        Gerencia.add(conta);
    }

    public String removerConta(int numero) {
        for (int i = 0; i < Gerencia.size(); i++) {
            if(Gerencia.get(i).getNumero() == numero) {
                Gerencia.remove(i);
                return "Conta removida com sucesso!";
            }   
        }
        return "Conta não localizada.";
    }

    public String listarContas() {
        String retorno = "";
        for (int i = 0; i < Gerencia.size(); i++) {
            retorno += Gerencia.get(i);
        }
        return retorno;
    }

    public Conta buscarConta(int numero) {
        for (int i = 0; i < Gerencia.size(); i++) {
            if(Gerencia.get(i).getNumero() == numero) {
                return Gerencia.get(i);
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cpf) {
        for (int i = 0; i < Gerencia.size(); i++) {
            if(Gerencia.get(i).getCliente().getCpf().equals(cpf)){
                return Gerencia.get(i).getCliente();  
            }
        }
        return null;
    }

    public boolean Transferencia(Conta origem, Conta destino, double valor) {
        if(origem.getSaldo() < valor) {
            return false;
        }
        origem.sacar(valor);
        destino.depositar(valor);
        return true;
    }

}
