package Questao_9;

import java.util.ArrayList;

public class GerenciadorDeImpostoDeRenda{
    private double total = 0;
    private ArrayList<Conta> tributaveis = new ArrayList<Conta>();

    public GerenciadorDeImpostoDeRenda(Conta conta){
        tributaveis.add(conta);
    }

    public void adicionarConta(Conta conta){
        tributaveis.add(conta);
    }

    public double calcularTributos(){
        total = 0;
        try{
            for(int i = 0; i < tributaveis.size(); i++){
                total = total + tributaveis.get(i).getTotal();
            }
        } catch(ArithmeticException e){
            System.out.println("Erro ao calcular tributo total");
        }
        // multiplicar por aliquota
        return total * 0.075;
    }
}
