package Questao_15;

import java.util.HashMap;

public class Aluno{
    private int matricula = 0;
    private String nome = "";
    private double ira = 0;
    private int curso = 0;
    private HashMap<Integer, String> cursos = new HashMap<Integer, String>();

    public Aluno(int matricula, String nome, double ira, int curso){
        this.cursos.put(1, "historia");
        this.cursos.put(2, "engenharia");
        this.cursos.put(3, "computacao");

        this.matricula = matricula;
        this.nome = nome;
        this.ira = ira;
        this.curso = curso;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public String getCurso() {
        return this.cursos.get(this.curso);
    }

    public int getCursoKey(){
        return this.curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
