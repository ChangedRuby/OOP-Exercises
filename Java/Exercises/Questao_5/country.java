package Questao_5;

public class country {
    private int codigo = 0;
    private String nome = "";
    private int populacao = 0;
    private int dimensao = 0;

    public country(int codigo, String nome, int dimensao){
        this.codigo = codigo;
        this.nome = nome;
        this.dimensao = dimensao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public boolean isEqual(country pais){
        if(pais.getCodigo() == this.getCodigo()){
            return true;
        } else{
            return false;
        }
    }

    public double densidade(){
        return (this.populacao / this.dimensao);
    }
}
