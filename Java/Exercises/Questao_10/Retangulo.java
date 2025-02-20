package Questao_10;

class Retangulo implements AreaCalculavel{
    private double base;
    private double altura;

    public Retangulo(){

    }

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }


    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public double calcularArea(){
        try{
            return base * altura;
        } catch(ArithmeticException e){
            System.out.println("Erro ao calcular area do retangulo");
        }
        return 0;
    }

    public void getAltura(double altura){
        this.altura = altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
