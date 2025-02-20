package Questao_16;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class TesteMapaAluno {
    public static void main(String[] args) {
        HashMap<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

        for(int i = 0; i < 5; i++){
            try{
                String[] input = JOptionPane.showInputDialog(null, "Qual a matricula, nome, ira e curso do aluno " + (i + 1) + ":", "Novo aluno", JOptionPane.INFORMATION_MESSAGE).split(" ");
                Aluno newAluno = new Aluno(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3]));
                alunos.put(newAluno.getMatricula(), newAluno);
            } catch(Exception e){
                System.out.println("Quantidade de parametros invalido");
                i = i - 1;
            }
        }

        JOptionPane.showMessageDialog(null, "Alunos adicionados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

        boolean repeat = true;

        while(repeat == true){
            int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a matricula do aluno:", "Buscar aluno", JOptionPane.INFORMATION_MESSAGE));

            if(alunos.containsKey(matricula)){
                Aluno aluno = alunos.get(matricula);

                JOptionPane.showMessageDialog(null, "Aluno de matricula " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Ira: " + aluno.getIra() + ", Curso e codigo: " + aluno.getCurso() + ", " + aluno.getCursoKey(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                repeat = false;
            } else{
                JOptionPane.showMessageDialog(null, "Matricula invalida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
