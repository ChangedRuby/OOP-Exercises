package Questao_6;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("1");
        Pessoa pessoa2 = new Pessoa("2");
        Pessoa pessoa3 = new Pessoa("3", pessoa1, pessoa2);
        Pessoa pessoa4 = new Pessoa("3", pessoa1, pessoa2);

        System.out.println(pessoa3.isEqual(pessoa4));

    }
}