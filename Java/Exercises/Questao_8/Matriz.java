package Questao_8;

import java.util.Arrays;

public class Matriz {
	private int[][] matriz;
	private int linha;
	private int coluna;
	
	Matriz(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.matriz = new int[linha][coluna];
	}

	Matriz(int linha, int coluna, int[] matriz) {
		this.linha = linha;
		this.coluna = coluna;
		this.matriz = new int[linha][coluna];

		int position = 0;
		for(int i = 0; i < this.linha; i++) {
			for(int j = 0; j < this.coluna; j++) {
				this.matriz[i][j] = matriz[position];
				position++;
			}
		}

	}
	
	public int getElement(int linha, int coluna){
		return this.matriz[linha][coluna];
	}
	
	public void setElement(int linha, int coluna, int valor) {
		matriz[linha][coluna] = valor;
	}

	public void setMatriz(Matriz matriz){
		this.linha = matriz.getLinha();
		this.coluna = matriz.getColuna();

		this.matriz = new int[matriz.getLinha()][matriz.getColuna()];
		this.matriz = matriz.getMatriz();
	}

	public void setMatriz(int[][] matriz){
		this.linha = matriz.length;
		this.coluna = matriz[0].length;

		this.matriz = new int[linha][coluna];
		this.matriz = matriz;
	}
	
	public Matriz sum(Matriz matriz1) {
		Matriz newMatriz = new Matriz(this.linha, this.coluna);
		if(this.getLinha() == matriz1.getLinha() && this.getColuna() == matriz1.getColuna()) {
			for(int i = 0; i < this.linha; i++) {
				for(int j = 0; i < this.coluna; j++) {
					newMatriz.setElement(i, j, matriz[i][j] + matriz1.getElement(i, j));
				}
			}
		}
		return newMatriz;
	}
	
	public boolean equals(Matriz matriz) {
		if(this == matriz) {
			return true;
		} else{
			if(matriz == null || this != matriz) {
				return false;
			}
			return false;
		}
	}
	
	public Matriz transpose() {
		Matriz newMatriz = new Matriz(this.getColuna(), this.getLinha());
		for(int i = 0; i < this.linha; i++) {
			for(int j = 0; j < this.coluna; j++) {
				newMatriz.setElement(j, i, this.getElement(i, j));
			}
		}
		return newMatriz;
	}

	public Matriz oposta() {
		Matriz newMatriz = new Matriz(this.getLinha(), this.getColuna());
		for(int i = 0; i < this.linha; i++) {
			for(int j = 0; j < this.coluna; j++) {
				newMatriz.setElement(i, j, -1 * this.getElement(i, j));
			}
		}
		return newMatriz;
	}

	public Matriz gerarNula(int linha, int coluna){
		Matriz newMatriz = new Matriz(linha, coluna);

		for(int i = 0; i < this.linha; i++) {
			for(int j = 0; j < this.coluna; j++) {
				newMatriz.setElement(i, j, 0);
			}
		}

		return newMatriz;
	}

	public boolean isIdentidade(){
		if(this.getLinha() == this.getColuna()) {
			for(int i = 0; i < this.linha; i++) {
				for(int j = 0; j < this.coluna; j++) {
					if(i == j){
						if(this.getElement(i, j) != 1) {
							return false;
						}
					} else{
						if(this.getElement(i, j) != 0) {
							return false;
						}
					}
				}
			}
		} else{
			return false;
		}
		return true;
	}

	public boolean isDiagonal(){
		if(this.getLinha() == this.getColuna()) {
			for(int i = 0; i < this.linha; i++) {
				for(int j = 0; j < this.coluna; j++) {
					if(i != j){
						if(this.getElement(i, j) != 0) {
							return false;
						}
					}
				}
			}
		} else{
			return false;
		}
		return true;
	}

	public boolean isSingular(){
		if(this.isDiagonal() == true) {
			for(int i = 0; i < this.linha; i++) {
				for(int j = 0; j < this.coluna; j++) {
					if(i == j){
						if(this.getElement(i, j) != this.getElement(0, 0)) {
							return false;
						}
					}
				}
			}
		} else{
			return false;
		}
		return true;
	}

	public boolean isSimetrica(){
		Matriz newMatriz = new Matriz(this.linha, this.coluna);
		newMatriz.setMatriz(this.transpose());
		if(this.getLinha() == this.getColuna()) {
			if(this.getMatriz() == newMatriz.getMatriz()){
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}

	public boolean isAssimetrica(){
		Matriz newMatriz = new Matriz(this.transpose().getLinha(), this.transpose().getColuna());
		newMatriz.setMatriz(this.transpose());

		Matriz newMatriz2 = new Matriz(this.oposta().getLinha(), this.oposta().getColuna());
		newMatriz2.setMatriz(this.oposta());

		//o deep equals é uma função que transforma uma matriz em uma string por meio do deeptostring e faz a verificação se os dois são iguais
		if(this.getLinha() == this.getColuna()) {
			if(Arrays.deepEquals(newMatriz.getMatriz(), newMatriz2.getMatriz())){
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}

	public Matriz subtrair(Matriz matriz){
		Matriz newMatriz = new Matriz(this.linha, this.coluna);

		if(this.getLinha() == this.getColuna()) {
			for(int i = 0; i < this.linha; i++) {
				for(int j = 0; j < this.coluna; j++) {
					newMatriz.setElement(i, j, this.getElement(i, j) - matriz.getElement(i, j));
				}
			}
		} else{
			return null;
		}
		return newMatriz;
	}

	public Matriz multiplicar(Matriz matriz){
		Matriz newMatriz = new Matriz(this.getLinha(), matriz.getColuna());
		newMatriz.setMatriz(newMatriz.gerarNula(this.getLinha(), matriz.getColuna()));

		for(int i = 0; i < this.linha; i++) {
			for(int j = 0; j < this.coluna; j++) {
				for(int k = 0; k < this.coluna; k++) {
					newMatriz.setElement(i, j, newMatriz.getElement(i, j) + this.getElement(k, j) * matriz.getElement(i, k));
				}
			}
		}
		return newMatriz;
	}

	public Matriz copy(){
		Matriz newMatriz = new Matriz(this.linha, this.coluna);
		newMatriz.setMatriz(this.getMatriz());
		return newMatriz;
	}

	public int getLinha() {
		return this.linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	public void printMatriz() {
		for(int i = 0; i < this.getLinha(); i++) {
			for(int j = 0; j < this.getColuna(); j++) {
				System.out.printf("%d ", matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	public int[][] getMatriz() {
		return matriz;
	}

}
