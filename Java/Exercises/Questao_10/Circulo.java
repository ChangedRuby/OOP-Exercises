package Questao_10;

class Circulo implements AreaCalculavel{
    private double raio;

    public Circulo(){

    }

    public Circulo(double raio) {
        this.raio = raio;
    }


    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        try{
            return Math.PI * raio * raio;
        } catch(ArithmeticException e){
            System.out.println("Erro ao calcular area");
        }
        return 0;
    }
}
