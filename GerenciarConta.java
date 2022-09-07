package cli;

import model.Conta;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarConta {
    public List<Conta>Lista = new ArrayList<>();

    public static void main(String[] args)
    {
        GerenciarConta gc =new GerenciarConta();
        Scanner sc =new Scanner(System.in);
        int opc =0;
        do{
           opc = construirMenu(gc, sc);

        }while(opc!=9);
    }

    private static int construirMenu(GerenciarConta gc, Scanner sc) {
        int opc;
        System.out.println("Menu");
        System.out.println("1. Cadastrar nova conta");
        System.out.println("2. Depositar");
        System.out.println("3. Sacar");
        System.out.println("4. Saldo");
        System.out.println("5. Saldo de Todas as Contas");
        System.out.println("6. Patrimonio liquido");
        System.out.println("9. Sair");
        System.out.println("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc){
            case 1:
                gc.execCadastrar(sc);
                break;
            case 2:
                gc.execDepositar(sc);
                break;
            case 3:
                gc.execSacar(sc);
                break;
            case 4:
                gc.execMostrarSaldo(sc);
                break;
            case 5:
                gc.execSaldoTodasContas();
                break;
            case 6:
                gc.execMostraPatrimonio();
                break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opcao invalida!");

        }
        return opc;
    }

    public void execCadastrar(Scanner sc){
        //Cadastra uma nova conta e a coloca na lista de contas
        Conta conta = new Conta();
        System.out.println("Digite o numero da conta");
        conta.setNumConta(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite o nome da cliente");
        conta.setNome(sc.nextLine());
        //Adicionar na lista
        Lista.add(conta);
        System.out.println("Conta cadastrada com sucesso");

    }

    public void execDepositar(Scanner sc){
        System.out.println("Digite o numero da conta a ser depositada: ");
        int proc = Integer.parseInt(sc.nextLine());
        Conta conta = null;
        //varrer a lista a procura do numero informado
        for(Conta c : Lista){
            if(c.getNumConta()==proc) {
                conta = c;
                break;
            }
        }
        if(conta!=null){
            System.out.println("Digite o valor do deposito: ");
            conta.depositar(Double.parseDouble(sc.nextLine()));
            System.out.println("Deposito efetuado com sucesso!");
        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void execSacar(Scanner sc){
        System.out.println("Digite o numero da conta a ser sacada: ");
        int proc = Integer.parseInt(sc.nextLine());
        Conta conta = null;
        //varrer a lista a procura do numero informado
        for(Conta c : Lista){
            if(c.getNumConta()==proc) {
                conta = c;
                break;
            }
        }
        if(conta!=null){
            System.out.println("Digite o valor do saque: ");
            boolean ok = conta.sacar(Double.parseDouble(sc.nextLine()));
            if(ok) {
                System.out.println("Saque efetuado com sucesso!");
            }else {
                System.out.println("Sem grana para sacar");
            }
        }else{
            System.out.println("Conta não encontrada");
        }
    }

    public void execMostrarSaldo(Scanner sc){
        System.out.println("Digite o numero da conta para verificar o saldo: ");
        int proc = Integer.parseInt(sc.nextLine());
        Conta conta = null;
        //varrer a lista a procura do numero informado
        for(Conta c : Lista){
            if(c.getNumConta()==proc) {
                conta = c;
                break;
            }
        }
        if(conta!=null) {
            System.out.println("O saldo da conta e: " + conta.getSaldo());
        }
    }

    public void execSaldoTodasContas(){
        for(Conta c: Lista){
            System.out.println(c.toString());
        }
    }

    public void execMostraPatrimonio(){
        double total = 0;
        for(Conta c: Lista){
            total +=c.getSaldo();
        }
        System.out.println("O total de todas as contas: " + total);
    }
}
