package Questao_11;

import java.util.Scanner;

public class TestaTributavel {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ContaCorrente conta1 = new ContaCorrente(0);
        ContaPoupanca conta2 = new ContaPoupanca(0);

        System.out.println("Digite conta a editar\n1 - Conta corrente\n2 - Conta poupanca");
        int input = teclado.nextInt();
        int conta = input;
        switch(conta){
            case 1:
                System.out.println("Visualizando conta corrente");
                break;
            case 2:
                System.out.println("Visualizando conta poupanca");
                break;
            default:
                System.out.println("Entrada invalida");
                break;
        }
        boolean repeat = true;
        while(repeat == true) {
            if(conta == 1){
                System.out.printf("Saldo da conta: %.2f\n", conta1.obterSaldo());
            } else if(conta == 2){
                System.out.printf("Saldo da conta: %.2f\n", conta2.obterSaldo());
            }
            System.out.println("Digite a operação\n1 - Sacar\n2 - Depositar\n3 - Obter Saldo\n4 - Obter Tributos\n5 - Sair");
            input = teclado.nextInt();
            if (conta == 1) {
                switch (input) {
                    case 1:
                        System.out.println("Valor a sacar: ");
                        try{
                            input = teclado.nextInt();
                            if(conta1.obterSaldo() - input >= 0){
                                conta1.sacar(input);
                            } else{
                                System.out.println("Saldo insuficiente");
                            }
                        } catch(Exception e){
                            System.out.println("Entrada invalida");
                        }
                        break;
                    case 2:
                        System.out.println("Valor a depositar: ");
                        input = teclado.nextInt();
                        conta1.depositar(input);
                        break;
                    case 3:
                        System.out.printf("Saldo: %f\n", conta1.obterSaldo());
                        break;
                    case 4:
                        System.out.printf("Tributos: %f\n", conta1.calculaTributos());
                        break;
                    case 5:
                        repeat = false;
                        break;
                    default:
                        System.out.println("Entrada invalida");
                        break;
                }
            } else {
                switch (input) {
                    case 1:
                        System.out.println("Valor a sacar: ");
                        input = teclado.nextInt();
                        if(conta2.obterSaldo() - input >= 0){
                            conta2.sacar(input);
                        } else{
                            System.out.println("Saldo insuficiente");
                        }
                        break;
                    case 2:
                        System.out.println("Valor a depositar: ");
                        input = teclado.nextInt();
                        conta2.depositar(input);
                        break;
                    case 3:
                        System.out.printf("Saldo: %f\n", conta2.obterSaldo());
                        break;
                    case 4:
                        System.out.println("Não há tributos para conta poupanca ");
                        break;
                    case 5:
                        repeat = false;
                        break;
                    default:
                        System.out.println("Entrada invalida");
                        break;
                }
            }
        }
    }
}
