package Questao_7;

public class Main {
    public static void main(String[] args) {
        Conjunto conjunto1 = new Conjunto();
        Conjunto conjunto2 = new Conjunto();
        conjunto1.addElement("a");
        conjunto1.addElement("b");
        conjunto1.addElement("c");

        conjunto2.addElement("b");
        conjunto2.addElement("c");
        conjunto2.addElement("d");

        System.out.println(conjunto1.contains("a"));

        Conjunto conjunto3 = new Conjunto(conjunto1.union(conjunto2));
        System.out.println("");
        conjunto3.print();

        System.out.println("\nInterseccao entre conjuntos: ");
        Conjunto conjunto4 = new Conjunto(conjunto1.inter(conjunto2));
        conjunto4.print();

        System.out.println("\nSubtração entre conjuntos: ");
        conjunto1.print();
        conjunto2.print();
        Conjunto conjunto5 = new Conjunto(conjunto1.menos(conjunto2));
        conjunto5.print();
    }
}
