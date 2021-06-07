import java.util.Scanner;

public class AppContas {
    public static void main(String[] args) {
        System.out.println("+--------------------------------+");
        System.out.println("| Gerenciamento de Contas - MENU |");
        System.out.println("+--------------------------------+\n");

        System.out.println("Selecione a opção desejada conforme abaixo: ");

        Scanner entrada = new Scanner(System.in);

        GerenciaConta Gerencia = new GerenciaConta();

        String nome, cpf, numero, limite, valor;

        Conta origem, destino;

        String menu = "0";

        do{
            System.out.println("\n1 - Cadastrar nova conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Excluir uma conta");
            System.out.println("6 - Transferência entre contas");
            System.out.println("7 - Sair\n");

            menu = entrada.nextLine();

            switch(Integer.parseInt(menu)) {
                case 1:
                    System.out.println("Qual tipo de conta será cadastrada?");
                    System.out.println("1 - Conta Corrente\n2 - Conta Poupança\n3 - Conta Especial");
                    System.out.println("Digite a opção desejada: ");
                        menu = entrada.nextLine();
                        switch(Integer.parseInt(menu)) {
                            case 1:
                                System.out.println("Informe o CPF do cliente:");
                                cpf = entrada.nextLine();
                                if(Gerencia.buscarCliente(cpf)!= null){
                                    Cliente P = Gerencia.buscarCliente(cpf);
                                    System.out.println("Cliente localizado!");
                                    System.out.println("Informe o número da conta que será criada: ");
                                    numero = entrada.nextLine();
                                    ContaCorrente C = new ContaCorrente(Integer.parseInt(numero), P);
                                    Gerencia.adicionarConta(C);
                                    System.out.println("Conta adicionada com sucesso!");
                                } else {
                                System.out.println("Informe o nome do cliente:");
                                nome = entrada.nextLine();
                                System.out.println("Informe o número da conta que será criada: ");
                                numero = entrada.nextLine();
                                Cliente P = new Cliente(nome, cpf);
                                ContaCorrente C = new ContaCorrente(Integer.parseInt(numero), P);
                                Gerencia.adicionarConta(C);
                                System.out.println("Conta adicionada com sucesso!");
                                }
                            break;

                            case 2:
                                System.out.println("Informe o CPF do cliente:");
                                cpf = entrada.nextLine();
                                if(Gerencia.buscarCliente(cpf)!= null){
                                    Cliente P = Gerencia.buscarCliente(cpf);
                                    System.out.println("Cliente localizado!");
                                    System.out.println("Informe o número da conta que será criada: ");
                                    numero = entrada.nextLine();
                                    ContaPoupanca C = new ContaPoupanca(Integer.parseInt(numero), P);
                                    Gerencia.adicionarConta(C);
                                    System.out.println("Conta adicionada com sucesso!");
                                } else {
                                System.out.println("Informe o nome do cliente:");
                                nome = entrada.nextLine();
                                System.out.println("Informe o número da conta que será criada: ");
                                numero = entrada.nextLine();
                                Cliente Q = new Cliente(nome, cpf);
                                ContaPoupanca D = new ContaPoupanca(Integer.parseInt(numero), Q);
                                Gerencia.adicionarConta(D);  
                                System.out.println("Conta adicionada com sucesso!");
                                } 
                            break;

                            case 3:
                                System.out.println("Informe o CPF do cliente:");
                                cpf = entrada.nextLine();
                                if(Gerencia.buscarCliente(cpf)!= null){
                                    Cliente P = Gerencia.buscarCliente(cpf);
                                    System.out.println("Cliente localizado!");
                                    System.out.println("Informe o número da conta que será criada: ");
                                    numero = entrada.nextLine();
                                    System.out.println("Informe o valor de limte da conta: ");
                                    limite = entrada.nextLine();
                                    ContaEspecial C = new ContaEspecial(Integer.parseInt(numero), P, Double.parseDouble(limite));
                                    Gerencia.adicionarConta(C);
                                    System.out.println("Conta adicionada com sucesso!");
                                } else {
                                System.out.println("Informe o nome do cliente:");
                                nome = entrada.nextLine();
                                System.out.println("Informe o número da conta que será criada: ");
                                numero = entrada.nextLine();
                                System.out.println("Informe o valor de limte da conta: ");
                                limite = entrada.nextLine();
                                Cliente R = new Cliente(nome, cpf);
                                ContaEspecial E = new ContaEspecial(Integer.parseInt(numero), R, Double.parseDouble(limite));
                                Gerencia.adicionarConta(E);
                                System.out.println("Conta adicionada com sucesso!");
                                }
                            break;
                            default:
                            System.out.println("Opção inválida!");
                        }
                break;

                case 2:
                    System.out.println(Gerencia.listarContas());
                break;

                case 3:
                    System.out.println("Digite o número da conta que deseja realizar o depósito: ");
                    numero = entrada.nextLine();
                    Conta aux = Gerencia.buscarConta(Integer.parseInt(numero));
                    if(aux != null) {
                        System.out.println("Digite o valor do depósito: ");
                        valor = entrada.nextLine();
                        if(Double.parseDouble(valor) > 0) {
                        aux.depositar(Double.parseDouble(valor));
                        System.out.println("Deposito efetuado com sucesso, valor R$ "+valor+"\nConta: "+aux.getNumero()+"\nBeneficiário: "+aux.getCliente().getNome());
                        } else {
                            System.out.println("Conta inválido!");
                        }
                    }

                break;

                case 4:
                    System.out.println("Digite o número da conta que deseja realizar o saque: ");
                    numero = entrada.nextLine();
                    Conta aux2 = Gerencia.buscarConta(Integer.parseInt(numero));
                    if(aux2 != null) {
                        System.out.println("Digite o valor do saque: ");
                        valor = entrada.nextLine();
                        if(Double.parseDouble(valor) > 0) {
                            if(aux2.sacar(Double.parseDouble(valor)) == true) { 
                            System.out.println("Saque efetuado com sucesso!");
                            } else {
                                System.out.println("Saldo insuficiente");
                            }
                        } else {
                            System.out.println("Valor inválido!");
                        }
                    } else {
                        System.out.println("Conta inválida!");
                    }

                break;

                case 5:
                    System.out.println("Digite o número da conta a ser excluída: ");
                    numero = entrada.nextLine();
                    System.out.println(Gerencia.removerConta(Integer.parseInt(numero))); 

                break;

                case 6:
                    System.out.println("Digite o numero da conta de origem");
                    numero = entrada.nextLine();
                    origem = Gerencia.buscarConta(Integer.parseInt(numero));
                    if(origem != null) {
                        System.out.println("Digite o numero da conta de destino");
                        numero = entrada.nextLine();
                        destino = Gerencia.buscarConta(Integer.parseInt(numero));
                        if(origem.getNumero() == destino.getNumero() || destino == null) {
                            System.out.println("Destino inválido");
                        }
                        System.out.println("Digite o valor da transferência");
                        valor = entrada.nextLine();
                        if(Gerencia.Transferencia(origem, destino, Double.parseDouble(valor)) == true) {
                            System.out.println("Transferência efetuada com sucesso!");
                        }
                    } else {
                        System.out.println("Numero de conta inválido!");
                    }


                break;

                case 7:
                    System.out.println("\n+--------------------+");
                    System.out.println("| Programa encerrado |");
                    System.out.println("+--------------------+");
                break;

                default:
                System.out.println("Opção inválida!");
            }

        } while(Integer.parseInt(menu) != 7);

        entrada.close();

    }
}
