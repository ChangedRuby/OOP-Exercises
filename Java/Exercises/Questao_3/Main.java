package Questao_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static Scanner teclado;
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Reta reta1 = new Reta(0, 0, 2, 2);
		System.out.printf("Coeficiente angular: %.2f\n", reta1.getAngular());
		System.out.printf("Coeficiente linear: %.2f\n", reta1.getLinear());
		System.out.printf("Ponto pertence: %b\n", reta1.check(0, 0));
		Reta reta2 = new Reta(0, 1, 5, 2);
		System.out.printf("Ponto de intersecao: %s\n", Arrays.toString(reta1.intersection(reta2)));
	}

}
