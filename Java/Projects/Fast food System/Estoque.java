import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Estoque {
    ArrayList<Produtos> estoque = new ArrayList<Produtos>();
    ArrayList<Integer> quantidade = new ArrayList<Integer>();

    String csvFile = "dados.csv";
    FileWriter writer = null;

    public Estoque(){

    }

    public Estoque(Produtos produto, int quantidade){
        this.adicionarProduto(produto, quantidade);
    }

    public void adicionarProduto(Produtos produto, int quantidade){
        int duplicate_pos = checkContains(produto); /* checa se um produto ja existe no estoque
                                                        e retorna a posição, retorna -1 caso falso */

        if(duplicate_pos >= 0){
            this.quantidade.set(duplicate_pos, this.quantidade.get(duplicate_pos) + quantidade);
            //System.out.printf("Estoque ja contem produto no posição [%d]\n", duplicate_pos);
        } else{
            this.estoque.add(produto);
            this.quantidade.add(quantidade);
        }
    }

    public void removerProduto(Produtos produto, int quantidade){
        int duplicate_pos = checkContains(produto);

        if(duplicate_pos >= 0){
            if(this.quantidade.get(duplicate_pos) < quantidade){
                System.out.println("Itens demais para remover");
            } else if(this.quantidade.get(duplicate_pos) == quantidade){
                this.estoque.remove(duplicate_pos);
                this.quantidade.remove(duplicate_pos);
            } else{
                this.quantidade.set(duplicate_pos, this.quantidade.get(duplicate_pos) - quantidade);
                //System.out.println("Produto removido");
            }
        } else{
            System.out.println("Produto não existe");
        }
    }

    public void removerProduto(int posicao, int quantidade){
        if(posicao >= 0 && posicao < this.estoque.size()){
            if(this.quantidade.get(posicao) < quantidade){
                System.out.println("Itens demais para remover");
            } else if(this.quantidade.get(posicao) == quantidade){
                this.estoque.remove(posicao);
                this.quantidade.remove(posicao);
            } else{
                this.quantidade.set(posicao, this.quantidade.get(posicao) - quantidade);
                //System.out.println("Produto removido");
            }
        } else{
            System.out.println("Produto não existe");
        }
    }

    public Produtos getProduto(int posicao){
        return this.estoque.get(posicao);
    }

    public int getQuantidade(int posicao){
        return this.quantidade.get(posicao);
    }

    public void imprimirEstoque(){
        System.out.println("Estoque: ");
        for(int i = 0; i < this.estoque.size(); i++){
            Produtos currentProduto = this.estoque.get(i);
            System.out.printf("[%d] %s, Tipo: %d, Nome: %s, Preço: %.2f, Valor nutricional: %.2f/kcal, Quantidade: %d \n", i, currentProduto.getClass().toString(),currentProduto.getTipo(), currentProduto.getNome(), currentProduto.getPreco(), currentProduto.getNutricional(), this.quantidade.get(i));
        }
    }

    public void saveCsv(){
        try {
            writer = new FileWriter(csvFile);
            String[][] writerBuffer = new String[this.estoque.size()][7];
            writer.append("sep=,\n"); // diz pro excel que o separador é a virgula

            for(int i = 0; i < writerBuffer.length; i++){
                Produtos currentProduto = this.estoque.get(i);

                writerBuffer[i][0] = currentProduto.getClass().toString();
                writerBuffer[i][1] = ", Tipo: " + Integer.toString(currentProduto.getTipo());
                writerBuffer[i][2] = ", Nome: " + currentProduto.getNome();
                writerBuffer[i][3] = ", Preco: R$" + currentProduto.getPreco().toString();
                writerBuffer[i][4] = ", Valor nutricional: " + currentProduto.getNutricional().toString();
                writerBuffer[i][5] = "/kcal, Quantidade: " + this.quantidade.get(i).toString();
                writerBuffer[i][6] = "\n";
            }

            for(int i = 0; i < writerBuffer.length; i++){
                for(int j = 0; j < writerBuffer[i].length; j++){
                    writer.append(writerBuffer[i][j]);
                }
            }
            System.out.println("Arquivo criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public int getSize(){
        return this.estoque.size();
    }

    public String getEstoqueStr(){
        String finalString = "";
        for(int i = 0; i < this.estoque.size(); i++){
            Produtos currentProduto = this.estoque.get(i);
            finalString += (i + " - " + currentProduto.getClass().toString() + ", Tipo: " + Integer.toString(currentProduto.getTipo()) + ", Nome: " + currentProduto.getNome() + ", Preço: R$" + currentProduto.getPreco().toString() + ", Valor nutricional: " + currentProduto.getNutricional().toString() + "/kcal, x" + this.quantidade.get(i).toString() + "\n");
        }
        return finalString;
    }

    private int checkContains(Produtos produto){
        for(int i = 0; i < this.estoque.size(); i++){
            if(this.estoque.get(i).getTipo() == produto.getTipo() && this.estoque.get(i).getClass() == produto.getClass()){
                return i;
            }
        }
        return -1;
    }
}
