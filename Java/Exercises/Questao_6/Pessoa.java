package Questao_6;

public class Pessoa {
    private String nome = "";
    private Pessoa pai;
    private Pessoa mae;

    public Pessoa(String nome, Pessoa pai, Pessoa mae){
        this.nome = nome;
        this.pai = pai;
        this.mae = mae;
    }

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String isEqual(Pessoa pessoa1) {
        if (this.nome == pessoa1.getNome() && this.mae == pessoa1.getMae()) {
            return "Verdadeiro";
        } else {
            return "Falso";
        }
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public Pessoa getMae() {
        return mae;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
