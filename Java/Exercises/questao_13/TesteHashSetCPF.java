package questao_13;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class TesteHashSetCPF {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HashSet<Integer> cpfs = new HashSet<Integer>();

        try{
            for(int i = 0; i < 10; i++){
                System.out.printf("Digite o cpf %d: \n", i + 1);
                cpfs.add(teclado.nextInt());
            }
        } catch(Exception e){
            System.out.println("Cpf invalido");
        }

        Iterator<Integer> it = cpfs.iterator();

        for(int i = 0; i < cpfs.size(); i++){
            System.out.printf("Cpf %d: %d\n", i + 1, it.next());
        }
    }
}
