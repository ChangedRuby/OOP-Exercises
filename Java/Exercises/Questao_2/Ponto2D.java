package Questao_2;

public class Ponto2D {

    public double abscissa, ordenada;
    
    public double getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(double abscissa) {
        this.abscissa = abscissa;
    }

    

    public double getOrdenada() {
        return ordenada;
    }

    public void setOrdenada(double ordenada) {
        this.ordenada = ordenada;
    }

   Ponto2D(){}

   Ponto2D(double x, double y){
        abscissa = x;
        ordenada = y;
    }

    Ponto2D(Ponto2D Ponto){
        abscissa = Ponto.getAbscissa();
        ordenada = Ponto.getOrdenada();
    }

    public double distanceTo(Ponto2D Ponto){
        return Math.sqrt(((abscissa - Ponto.getAbscissa()) * (abscissa - Ponto.getAbscissa())) + (ordenada - Ponto.getOrdenada()) * (ordenada - Ponto.getOrdenada()));
    }

    

}
