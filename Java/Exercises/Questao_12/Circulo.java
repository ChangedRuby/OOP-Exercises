package Questao_12;

public class Circulo {
    private double raio = 0;

    public Circulo(double raio){
        this.raio = raio;
    }

    public double calcularArea(){
        try{
            return Math.PI * this.raio * this.raio;
        } catch(ArithmeticException e){
            System.out.println("Erro ao calcular area do circulo");
            return 0;
        }
    }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
