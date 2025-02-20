package Questao_11;

public class ContaCorrente extends Conta implements Tributavel{
    public ContaCorrente(double saldo){
        super(saldo);
    }

    public double calculaTributos(){
        return (super.obterSaldo() * 0.01) + 42;
    }
}
