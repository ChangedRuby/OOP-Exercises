package Questao_4;

public class Circulo {
    private double x = 0;
    private double y = 0;
    private double raio = 0;

    public Circulo(int raio){
        this.x = 0;
        this.y = 0;
        this.raio = raio;
    }

    public Circulo(int x, int y, int raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public double getRaio(){
        return raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }

    public void inflar(double amount){
        this.raio = this.raio + amount;
    }

    public void desinflar(double amount){
        this.raio = this.raio - amount;
    }

    public double getArea(){
        return (this.raio * this.raio * 3.14);
    }
}
