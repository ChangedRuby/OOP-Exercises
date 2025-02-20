package Questao_9;

public class Main {
    public static void main(String[] args) {
        // Criar contas
        Conta conta1 = new Conta(100);
        Conta conta2 = new Conta(100);

        // Criar gerenciador
        GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda(conta1);
        // Adicionar tributo na conta 1
        conta1.adicionarTributo(100);
        System.out.printf("Tributos das contas: %.2f\n", gerenciador.calcularTributos());
        // Adicionar outra conta no gerenciador, para calcular o tributo total das duas contas
        gerenciador.adicionarConta(conta2);
        System.out.printf("Tributos das contas: %.2f\n", gerenciador.calcularTributos());
        }
}
