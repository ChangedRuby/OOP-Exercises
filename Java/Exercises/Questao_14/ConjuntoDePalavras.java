package Questao_14;

import java.util.HashSet;
import java.util.Iterator;

public class ConjuntoDePalavras {
    HashSet<String> palavras = new HashSet<>();

    public ConjuntoDePalavras(String palavras){
        String[] individual = palavras.split(" ");

        for(int i = 0; i < individual.length; i++){
            this.palavras.add(individual[i]);
        }
    }

    public boolean contemTodas(String palavras){
        String[] individual = palavras.split(" ");

        for(int i = 0; i < individual.length; i++){
            if(this.palavras.contains(individual[i]) == false){
                return false;
            }
        }
        return true;
    }

    public void adicionarPalavra(String palavra){
        this.palavras.add(palavra);
    }

    public void imprimirConjunto(){
        Iterator<String> it = this.palavras.iterator();

        System.out.println("Conjunto: ");
        for(int i = 0; i < this.palavras.size(); i++){
            System.out.printf("- %s\n", it.next());
        }
        System.out.println();
    }
}
