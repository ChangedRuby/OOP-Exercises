import javax.swing.*;

public class Cliente implements Pessoa{

    private String cpf = "";
    private String nome = "";

    Pedido pedido = new Pedido();

    public Cliente(String nome, String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");
        if(cpf.length() == 11){
            this.setNome(nome);
            this.setCpf(cpf);
        } else{
            System.out.println("O cpf não tem 11 digitos numéricos");
        }
    }

    public void addPedido(Produtos produto, int quantidade){
        if(quantidade > 0){
            pedido.adicionarProduto(produto, quantidade);
        } else{
            System.out.println("Quantidade invalida");
        }
        //System.out.println("Produto adicionado");
    }

    public double calcPreco(){
        return this.pedido.calcPreco();
    }

    public double calcNutricional(){
        return this.pedido.calcNutricional();
    }

    public void concluirPedido(){
        this.pedido.concluirPedido();
    }

    public void printPedido(){
        if(this.pedido.getSize() > 0){
            this.pedido.imprimirPedido();
        } else{
            JOptionPane.showMessageDialog(null, "Pedido vazio");
        }
    }

    public Produtos getProduto(int posicao){
        return this.pedido.getProduto(posicao);
    }

    public int getQuantidade(int posicao){
        return this.pedido.getQuantidade(posicao);
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

}
