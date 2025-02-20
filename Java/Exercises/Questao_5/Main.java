package Questao_5;

public class Main {
    public static void main(String[] args) {
    country pais1 = new country(10, "nome", 100);
    country pais2 = new country(10, "nome2", 100);
    pais1.setPopulacao(1000);
    System.out.printf("É igual: %b\n", pais1.isEqual(pais2));
    System.out.printf("Densidade populacional do pais: %.2f/km^2", pais1.densidade());
    }
}
