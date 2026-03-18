import java.util.Scanner;

class Conta{
    double saldo;
    String senhatst;
    String cpf;
    String nome;
}
class menu{
    static void mostrarMenu(){
        System.out.println("MENU");
        System.out.println("........................");
        System.out.println("1-- Extrato");
        System.out.println("2-- Sacar");
        System.out.println("3-- Depositar");
        System.out.println("4-- SAIR");
        System.out.println("........................");
    }
}
class bank{
    static void banks(){
         System.out.println("Escolha seu banco digitando o número");
         System.out.println("1-- NuBank");
         System.out.println("2-- Santander");
         System.out.println("3-- C6 Bank");
         System.out.println("4-- Ítau");
         System.out.println("5-- Banco do Brasil");
         System.out.println("6-- Caixa");
    }
}
public class Caixa2{
    public static void main(String[]args){
        Conta conta = new Conta();
        Scanner scanner =  new Scanner(System.in);


        System.out.println("Login");
        String myBank = "banco";
        bank.banks();
        String respostbank = scanner.nextLine().trim();
        if (respostbank.equals("1")){
            myBank ="Nubank";
        }else if(respostbank.equals("2")){
            myBank = "Santander";
        }else if(respostbank.equals("3")){
             myBank = "C6 Bank";
        }else if(respostbank.equals("4")){
            myBank = "Ítau";
        }else if(respostbank.equals("5"))
            {
             myBank = "Banco do Brasil";
        }else if(respostbank.equals("6")){
             myBank = "Caixa";
        }else{
            System.out.println("Banco inválido");
        }
        System.out.println("-Banco selecionado-");
        System.out.print("Digite seu nome : ");
        conta.nome = scanner.nextLine();
        System.out.print("Digite sua senha:");
        conta.senhatst = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        conta.cpf = scanner.nextLine();
        System.out.println("Informaçoes salvas");

        boolean rodando = true;
        int tentativas=0;
        while(rodando){
            
        menu.mostrarMenu();

        int resposta = scanner.nextInt();
        //saldo
        switch(resposta){
        case 1:
        System.out.println("Banco: " + myBank);
        System.out.println("Nome: " + conta.nome);
        System.out.println("CPF: " + conta.cpf);
        System.out.println("Saldo :"+ conta.saldo);
        break;
        //saque
            case 2:
            System.out.println("Quanto você deseja sacar ?");
            int sacar = scanner.nextInt();
            scanner.nextLine();
            if(sacar>conta.saldo){
                System.out.println("Saque Bloqueado "); 
            }else{
                System.out.println("Verificação de CPF// Digite seu CPF:");
                String verificarcpf = scanner.nextLine();
                if(verificarcpf.equals(conta.cpf)){
                    System.out.println("Verificação de CPF bem-sucedida");
                    System.out.println("Verificação de senha// Digite sua senha :");
                    String verificarsenha = scanner.nextLine();
                    if(verificarsenha.equals(conta.senhatst)){
                    System.out.println("Verificação de senha bem-sucedida");
                    System.out.println("Banco: " + myBank);
                    System.out.println("Nome: " + conta.nome);
                    System.out.println("CPF: " + conta.cpf);
                    conta.saldo -= sacar;   
                    System.out.println("Saldo:" + conta.saldo);
                }else{
                    //contador de erro de senha
                    System.out.println("Senha incorreta");
                    tentativas++;
                    if (tentativas>=3){
                      System.out.println("//Sua Conta bloqueada temporáriamente//");
                      rodando=false;
                    }
                }
                }else{
                    //contador de erro no cpf
                    System.out.println("CPF incorreto");
                    tentativas++;
                    if (tentativas>=3){
                      System.out.println("//Sua Conta bloqueada temporáriamente//");
                      rodando=false;
                }
                }
             }
             break;
             //sair, tá primeiro do 3 pq é gambiarra
         case 4:
          System.out.println("Saindo...");
          rodando = false;
          break;
          //depositar
        case 3:
          System.out.println("Quanto deseja depositar");
          int depositar = scanner.nextInt();
          scanner.nextLine();
          if(depositar<=0){
            System.out.println("Valor inválido");
            scanner.nextLine();
          }else{
             System.out.println("Verificação de CPF // Digite seu CPF:");
                String verificarcpf = scanner.nextLine();
                if(verificarcpf.equals(conta.cpf)){
                    System.out.println("Verificação de CPF bem-sucedida");
                    System.out.println("Verificação de senha// Digite sua senha :");
                    String verificarsenha = scanner.nextLine();
                    if(verificarsenha.equals(conta.senhatst)){
                    System.out.println("Verificação de senha bem-sucedida");
                    System.out.println("Banco: " + myBank);
                    System.out.println("Nome: " + conta.nome);
                    System.out.println("CPF: " + conta.cpf);
                    conta.saldo += depositar;
                    System.out.println("Saldo:" + conta.saldo);
                }else{
                    //contador de erro na senha
                    System.out.println("Senha incorreta");
                    tentativas++;
                    if (tentativas>=3){
                      System.out.println("//Sua Conta bloqueada temporáriamente//");
                      rodando=false;
                    }
                }
            }else{
                //contador de erro no cpf
                System.out.println("CPF Incorreto");
                tentativas++;
                if (tentativas>=3){
                      System.out.println("//Sua Conta bloqueada temporáriamente//");
                      rodando=false;
                }
            }
        }
        break;
             default:
    System.out.println("Opção inválida");
                System.out.println("Deseja reabrir o menu ?");
                System.out.println("1-- Sair");
                System.out.println("2-- Menu");
                int voltar = scanner.nextInt();
               if (voltar == 1){
                System.out.println("Ok, saindo...");
                rodando = false;
         }
    }
   }
 }
}