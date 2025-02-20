package Questao_9;

import java.util.ArrayList;

public class Conta implements Tributavel{
    private double total = 0;
    private ArrayList<Double> tributos = new ArrayList<Double>();

    public Conta(double tributoInicial){
        tributos.add(tributoInicial);
    }

    public void adicionarTributo(double valor){
        try{
            tributos.add(valor);
        } catch(Exception e){
            System.out.println("Entrada invalida ao adicionar tributo");
        }
    }

    public double getTotal(){
        total = 0;
        for(int i = 0; i < tributos.size(); i++){
            total = total + this.getTributo(i);
        }
        return total;
    }

    public double getTributo(int tributo){
        return tributos.get(tributo);
    }
}
