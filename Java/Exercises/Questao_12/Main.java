package Questao_12;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
            HashMap<Integer, Circulo> circulos = new HashMap<Integer, Circulo>();

            Circulo circulo1 = new Circulo(10);
            Circulo circulo2 = new Circulo(20);
            Circulo circulo3 = new Circulo(30);
            Circulo circulo4 = new Circulo(40);
            Circulo circulo5 = new Circulo(50);

            circulos.put(10, circulo1);
            circulos.put(5, circulo2);
            circulos.put(20, circulo3);
            circulos.put(2, circulo4);
            circulos.put(4, circulo5);

            Iterator<Integer> it = circulos.keySet().iterator();

            for(int i = 0; i < 5; i++){
                int next = it.next();
                System.out.printf("Raio do circulo de chave %d: %.2f\n", next, circulos.get(next).calcularArea());
            }
        }
}
