public class Gerente extends Funcionario{

    Estoque estoque = new Estoque(); // cria o estoque do gerente

    public Gerente(){

    }

    public Gerente(String nome, String cpf){
        super.setNome(nome);
        super.setCpf(cpf);
    }

    public void addEstoque(Produtos produto, int quantidade){
        if(produto != null && produto.getTipo() != -1){
            if(quantidade > 0){
                estoque.adicionarProduto(produto, quantidade);
            } else{
                System.out.println("Quantidade invalida");
            }
        } else{
            System.out.println("Tipo do produto não é valido");
        }
    }

    public void printEstoque(){
        if(this.estoque.getSize() > 0){
            this.estoque.imprimirEstoque();
        } else{
            System.out.println("Estoque não contem nenhum produto");
        }
    }

    public void saveCsv(){
        this.estoque.saveCsv();
    }

    public void removerProduto(Produtos produto, int quantidade){
        estoque.removerProduto(produto, quantidade);
    }

    public void removerProduto(int posicao, int quantidade){
        estoque.removerProduto(posicao, quantidade);
    }

    public String getEstoqueStr(){
        return this.estoque.getEstoqueStr();
    }

    public Produtos getProduto(int posicao){
        return this.estoque.getProduto(posicao);
    }

    public int getQuantidade(int posicao){
        return this.estoque.getQuantidade(posicao);
    }

    public Estoque getEstoque(){
        return this.estoque;
    }
}
