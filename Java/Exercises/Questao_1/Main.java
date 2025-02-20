package Questao_1;

public class Main {
    public static void main(String[] args) {
        Contador valor1 = new Contador(0);
        valor1.Incrementar();
        System.out.printf("Valor do contador: %d", valor1.getValor());
    }
}
