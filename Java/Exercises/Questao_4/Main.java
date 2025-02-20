package Questao_4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Circulo circle1 = new Circulo(0, 0, 10);
    circle1.inflar(10);
    System.out.printf("Area do circulo: %.2f\n", circle1.getArea());
    }
}