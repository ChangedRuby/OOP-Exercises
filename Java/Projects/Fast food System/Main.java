import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        boolean repeat = true;

        Hamburger produto1 = new Hamburger(1);
        Hamburger produto2 = new Hamburger(2);
        Hamburger produto3 = new Hamburger(1);
        Bebida produto4 = new Bebida(3);

        Gerente gerente = new Gerente(); // o gerente fica com o estoque
        Cliente cliente1 = new Cliente("augusto", "12345678901");
        Cadastros cadastros = new Cadastros();


        //cadastros.Cadastrar(cliente1);

        //gerente.addEstoque(produto1, 1);
        /*
        cadastros.printCadastros();
        gerente.addEstoque(produto1, 2);
        gerente.addEstoque(produto3, 1);
        gerente.addEstoque(produto2, 1);
        gerente.addEstoque(produto4, 1);
        gerente.printEstoque();
        gerente.saveCsv();
        //
        System.out.println(gerente.getProduto(0).getTipo());
        System.out.println(gerente.getQuantidade(0));
        //
        System.out.println("");

        cadastros.getCadastroCpf(39).addPedido(gerente.getProduto(0), 1);
        cadastros.getCadastroCpf(39).addPedido(gerente.getProduto(0), 1);
        cadastros.getCadastroCpf(39).addPedido(gerente.getProduto(2), 1);
        cadastros.getCadastroCpf(39).printPedido();
        System.out.println(cadastros.getCadastro(0).calcPreco());
        */
        int input, amount, type;
        String name, cpf;

        while(repeat == true){
            try{
                input = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual ação deseja realizar: \n" +
                        "\n" +
                        "1 - Adicionar produto no estoque\n" +
                        "2 - Cadastrar cliente\n" +
                        "3 - Adicionar produto no pedido de cliente\n" +
                        "4 - Calcular preco do pedido de cliente\n" +
                        "5 - Calcular valor nutricional do pedido de cliente\n" +
                        "---------\n" +
                        "6 - Salvar estoque em CSV\n" +
                        "---------\n" +
                        "7 - Visualizar estoque\n" +
                        "8 - Visualizar pedido\n" +
                        "9 - Visualizar cardapio\n" +
                        "10 - Visualizar cadastros\n" +
                        "---------\n" +
                        "11 - Concluir pedido\n" +
                        "12 - Sair\n", "Escolha a função", JOptionPane.QUESTION_MESSAGE));

                switch(input){
                    case 1: // adicionar produto estoque
                        input = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o produto\n" +
                                "1 - Hamburger\n" +
                                "2 - Bebida\n"));

                        if(input == 1){
                            type = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o tipo\n" +
                                    "1 - Queijo\n" +
                                    "2 - Bigmac\n" +
                                    "3 - Bacon\n"));
                        } else if(input == 2){
                            type = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o tipo\n" +
                                    "1 - Limão\n" +
                                    "2 - Coca cola\n" +
                                    "3 - Laranja\n"));
                        } else{
                            type = -1;
                        }

                        amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a quantidade\n"));

                        switch(input){
                            case 1:
                                Hamburger newProduto1 = new Hamburger(type);
                                gerente.addEstoque(newProduto1, amount);
                                break;
                            case 2:
                                Bebida newProduto2 = new Bebida(type);
                                gerente.addEstoque(newProduto2, amount);
                                break;
                            default:
                                System.out.println("Produto invalido");
                                break;
                        }
                        break;
                    case 2:
                        name = JOptionPane.showInputDialog(null, "Qual o nome");
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf\nO cpf deve conter 11 digitos numéricos\n");

                        Cliente newCliente = new Cliente(name, cpf);
                        cadastros.Cadastrar(newCliente);
                        break;
                    case 3:
                        input = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o produto do estoque\n" + gerente.getEstoqueStr()));

                        amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a quantidade\n"));
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf do cliente\n");

                        if(gerente.getQuantidade(input) - amount >= 0){
                            cadastros.getCadastroCpf(cpf).addPedido(gerente.getProduto(input), amount);
                            gerente.removerProduto(input, amount);
                        } else{
                            System.out.println("O estoque não contem a quantidade pedida do produto");
                        }
                        break;
                    case 4:
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf do cliente\n");

                        System.out.printf("Preço total: R$%.2f\n", cadastros.getCadastroCpf(cpf).calcPreco());
                        break;
                    case 5:
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf do cliente\n");

                        System.out.printf("Valor nutricional total: %.2f/kcal\n", cadastros.getCadastroCpf(cpf).calcNutricional());
                        break;
                    case 6:
                        gerente.saveCsv();
                        break;
                    case 7:
                        gerente.printEstoque();
                        break;
                    case 8:
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf do cliente\n");
                        cadastros.getCadastroCpf(cpf).printPedido();
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, """
                            Hamburger:
                            1 - Queijo
                            2 - Bigmac
                            3 - Bacon
                            Bebida:
                            1 - Limão
                            2 - Coca cola
                            3 - Laranja
                            """, "Cardapio", JOptionPane.INFORMATION_MESSAGE); // """ """ é uma forma de fazer um bloco de texto que cada linha tem \n
                        break;
                    case 10:
                        cadastros.printCadastros();
                        break;
                    case 11:
                        cpf = JOptionPane.showInputDialog(null, "Qual o cpf do cliente\n");
                        cadastros.getCadastroCpf(cpf).concluirPedido();
                        break;
                    case 12:
                        repeat = false;
                        break;
                    default:
                        System.out.println("Entrada invalida ");
                        break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Entrada invalida\nMensagem de desenvolvedor:\n" + e, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
