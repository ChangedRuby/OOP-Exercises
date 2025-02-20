package Questao_11;

public class Conta{
    private double saldo;

    public Conta(double saldo){
        this.saldo = saldo;
    }

    public void sacar(double valor){
        try{
            if(this.saldo - valor >= 0){
                this.saldo = this.saldo - valor;
            }
        } catch(ArithmeticException e){
            System.out.println("Erro ao sacar da conta");
        }
    }

    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }

    public double obterSaldo(){
        return this.saldo;
    }
}
