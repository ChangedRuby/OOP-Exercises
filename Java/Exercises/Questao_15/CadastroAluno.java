package Questao_15;

import java.util.ArrayList;

public class CadastroAluno {
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public CadastroAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public CadastroAluno(){

    }

    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    public void ordenar(){
        for(int i = 0; i < this.alunos.size(); i++){
            int menor = i;
            for(int j = i + 1; j < this.alunos.size(); j++){
                if(this.alunos.get(j).getMatricula() < this.alunos.get(menor).getMatricula()){
                    menor = j;
                }
            }
            Aluno reserva = this.alunos.get(i);
            this.alunos.set(i, this.alunos.get(menor));
            this.alunos.set(menor, reserva);
        }
    }

    public void imprimirLista(){
        for(int i = 0; i < this.alunos.size(); i++){
            Aluno aluno = this.alunos.get(i);
            System.out.printf("Aluno de matricula %d, Nome: %s, Ira: %.2f, Curso e codigo: %s, %d\n", aluno.getMatricula(), aluno.getNome(), aluno.getIra(), aluno.getCurso(), aluno.getCursoKey());
        }
    }

}
