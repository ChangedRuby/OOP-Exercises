package Questao_8;

public class main {

	public static void main(String[] args) {
		Matriz matriz1 = new Matriz(2, 2, new int[]{1, 2, 3, 4});
		Matriz matriz2 = new Matriz(2, 2, new int[]{1, 2, 3, 4});
		Matriz matriz3 = new Matriz(3, 3, new int[]{2, 0, 0, 0, 2, 0, 0, 0, 2});
		Matriz matriz4 = new Matriz(3, 3, new int[]{0, 7, -1, -7, 0, 4, 1, -4, 0});
		Matriz matriz5 = new Matriz(2, 2, new int[]{1, 2, 3, 4});
		Matriz matriz6 = new Matriz(2, 2, new int[]{1, 2, 3, 4});

		System.out.println(matriz1.equals(matriz2));
		matriz1.printMatriz();
		matriz1.setMatriz(matriz1.transpose());
		matriz1.printMatriz();

		matriz1.setMatriz(matriz1.oposta());
		matriz1.printMatriz();

		matriz1.setMatriz(matriz1.gerarNula(2, 2));
		matriz1.printMatriz();

		System.out.println();
		matriz3.printMatriz();
		System.out.println(matriz3.isIdentidade());
		System.out.println(matriz3.isDiagonal());
		System.out.println(matriz3.isSingular());
		System.out.println(matriz3.isSimetrica());
		System.out.println(matriz4.isAssimetrica());

		matriz4.setMatriz(matriz4.subtrair(matriz3));
		matriz4.printMatriz();

		matriz5.setMatriz(matriz5.multiplicar(matriz6));
		matriz5.printMatriz();

		matriz6.setMatriz(matriz5.copy());
		matriz6.printMatriz();

	}

}
