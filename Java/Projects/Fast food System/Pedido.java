import javax.swing.*;
import java.util.ArrayList;

public class Pedido{

    ArrayList<Produtos> pedido = new ArrayList<Produtos>();
    ArrayList<Integer> quantidade = new ArrayList<Integer>();

    public Pedido(){

    }

    public Pedido(Produtos produto, int quantidade){
        adicionarProduto(produto, quantidade);
    }

    public void adicionarProduto(Produtos produto, int quantidade){
        int duplicate_pos = checkContains(produto); /* checa se um produto ja existe no estoque
                                                        e retorna a posição, retorna -1 caso falso */

        if(duplicate_pos >= 0){
            this.quantidade.set(duplicate_pos, this.quantidade.get(duplicate_pos) + quantidade);
            System.out.printf("Pedido ja contem produto no posição [%d]\n", duplicate_pos);
        } else{
            this.pedido.add(produto);
            this.quantidade.add(quantidade);
        }
    }

    public Produtos getProduto(int posicao){
        return this.pedido.get(posicao);
    }

    public int getQuantidade(int posicao){
        return this.quantidade.get(posicao);
    }

    public double calcPreco(){
        double total = 0;
        for(int i = 0; i < this.pedido.size(); i++){
            total += this.pedido.get(i).getPreco() * this.quantidade.get(i);
        }
        return total;
    }

    public double calcNutricional(){
        double total = 0;
        for(int i = 0; i < this.pedido.size(); i++){
            total += this.pedido.get(i).getNutricional() * this.quantidade.get(i);
        }
        return total;
    }

    public void concluirPedido(){
        if(this.quantidade.size() > 0){
            JOptionPane.showMessageDialog(null, "Pedido concluido com sucesso\nPreço total: " + this.calcPreco() + "\nValor nutricional total: " + this.calcNutricional());

            this.pedido.clear();
            this.quantidade.clear();
        } else{
            JOptionPane.showMessageDialog(null, "Não há nenhum produto no pedido para ser concluido");
        }
    }

    public void printPreco(){
        System.out.printf("Preço total: R$%.2f\n", this.calcPreco());
    }

    public void printNutricional(){
        System.out.printf("Valor nutricional total: %.2f/kcal\n", this.calcNutricional());
    }

    public int getSize(){
        return this.pedido.size();
    }

    public void imprimirPedido(){
        System.out.println("Pedido: ");
        for(int i = 0; i < this.pedido.size(); i++){
            Produtos currentProduto = this.pedido.get(i);
            System.out.printf("[%d] %s, Tipo: %d, Nome: %s, Preço: R$%.2f, Valor nutricional: %.2f/kcal, Quantidade: %d \n", i, currentProduto.getClass().toString(),currentProduto.getTipo(), currentProduto.getNome(), currentProduto.getPreco(), currentProduto.getNutricional(), this.quantidade.get(i));
        }
        this.printPreco();
        this.printNutricional();
    }

    private int checkContains(Produtos produto){
        for(int i = 0; i < this.pedido.size(); i++){
            if(this.pedido.get(i).getTipo() == produto.getTipo() && this.pedido.get(i).getClass() == produto.getClass()){
                return i;
            }
        }
        return -1;
    }
}
