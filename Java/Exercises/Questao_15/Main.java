package Questao_15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        CadastroAluno cadastro = new CadastroAluno();


        for(int i = 0; i < 10; i++){
            try{
                System.out.printf("Qual a matricula, nome, ira e curso do aluno %d: ", i + 1);

                String[] input = teclado.nextLine().split(" ");

                int matricula = Integer.parseInt(input[0]);
                String nome = input[1];
                double ira = Double.parseDouble(input[2]);
                int curso = Integer.parseInt(input[3]);

                Aluno aluno$i = new Aluno(matricula, nome, ira, curso);
                cadastro.adicionarAluno(aluno$i);
                System.out.println("Aluno adicionado");
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Quantidade de atributos do aluno errado");
                i = i - 1;
            }
        }

        cadastro.ordenar();
        cadastro.imprimirLista();
    }
}
