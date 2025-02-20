package Questao_10;

public class Main {
    public static void main(String[] args) {
        AreaCalculavel[] array1 = new AreaCalculavel[5];
        array1[0] = new Quadrado(10);
        array1[1] = new Circulo(10);
        array1[2] = new Retangulo(10, 5);
        array1[3] = new Retangulo(2, 5);
        array1[4] = new Circulo(3);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Area do objeto %d: %.2f \n", i + 1, array1[i].calcularArea());
        }
    }
}
