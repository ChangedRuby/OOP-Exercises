package Questao_10;

class Quadrado implements AreaCalculavel{
    private double lado;

    public Quadrado(){

    }

    public Quadrado(double lado) {
        this.lado = lado;
    }


    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        try{
            return lado * lado;
        } catch(ArithmeticException e){
            System.out.println("Erro ao calcular area do quadrado");
        }
        return 0;
    }
}
