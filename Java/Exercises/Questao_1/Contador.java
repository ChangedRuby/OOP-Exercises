package Questao_1;

public class Contador {
    private int valor;

    public Contador(){
        valor = 0;
    }

    public Contador(int valor){
        this.valor = valor;
    }

    public void Zerar(){
        this.valor = 0;
    }

    public void Incrementar(){
        this.valor = this.valor + 1;
    }

    public int getValor(){
        return this.valor;
    }
}
