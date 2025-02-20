package Questao_14;

public class Main {
    public static void main(String[] args) {
        ConjuntoDePalavras conjunto1 = new ConjuntoDePalavras("gato cachorro");

        conjunto1.adicionarPalavra("lontra");
        conjunto1.imprimirConjunto();
        System.out.printf("Contem todos: %b", conjunto1.contemTodas("gato casa"));
    }
}
