package Questao_2;

public class main
{
	public static void main(String[] args) {
		Ponto2D ponto1 = new Ponto2D();
		Ponto2D ponto2 = new Ponto2D(10, 12);

		Ponto2D ponto3 = new Ponto2D(ponto1);

		System.out.printf("Distancia pro ponto: %.2f\n", ponto3.distanceTo(ponto2));

		ponto1.abscissa = 0;
		ponto1.ordenada = 0;
	}
}
