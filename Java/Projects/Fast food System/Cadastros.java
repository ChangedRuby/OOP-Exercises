import javax.swing.*;
import java.util.ArrayList;

public class Cadastros {

    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cadastros(){

    }

    public void Cadastrar(Cliente cliente){
        if(checkContains(cliente) == -1){
            if(cliente.getCpf().equals("") == false){
                this.clientes.add(cliente);
                System.out.println("Cliente cadastrado!");
            }
        } else{
            System.out.println("Ja existe um cadastro com o mesmo cpf");
        }
    }

    public Cliente getCadastro(int posicao){
        return this.clientes.get(posicao);
    }

    // retorna o cliente de certo cpf, retorna null caso falso
    public Cliente getCadastroCpf(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getCpf().equals(cpf) == true){
                return this.clientes.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Cpf não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public void removeCadastro(int posicao){
        this.clientes.remove(posicao);
    }

    public void printCadastros(){
        if(this.clientes.size() > 0){
            System.out.println("Cadastros: ");
            for(int i = 0; i < clientes.size(); i++){
                System.out.printf("[%d] Nome: %s, Cpf: %s\n", i, clientes.get(i).getNome(), clientes.get(i).getCpf());
            }
        } else{
            System.out.println("Não há clientes cadastrados");
        }
    }

    private int checkContains(Cliente cliente){
        for(int i = 0; i < this.clientes.size(); i++){
            if(this.clientes.get(i).getCpf() == cliente.getCpf()){
                return i;
            }
        }
        return -1;
    }
}
