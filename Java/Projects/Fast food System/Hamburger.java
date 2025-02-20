import java.util.HashMap;

public class Hamburger implements Produtos{
    HashMap<Integer, String> nomes = new HashMap<Integer, String>();
    HashMap<Integer, Double> precos = new HashMap<Integer, Double>();
    HashMap<Integer, Double> nutricional = new HashMap<Integer, Double>();
    private int tipo = 0; // tipo é a key dos hashmap

    public Hamburger(int tipo){
        setupMap(); // hashMap setup

        if(nomes.containsKey(tipo)){
            this.tipo = tipo;
        } else{
            this.tipo = -1;
            //System.out.println("Tipo do produto nao presente");
        }
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome(){
        return this.nomes.get(this.tipo);
    }

    public Double getPreco(){
        return this.precos.get(this.tipo);
    }

    public Double getNutricional(){
        return this.nutricional.get(this.tipo);
    }

    public String getNome(int tipo){
        return this.nomes.get(tipo);
    }

    public Double getPreco(int tipo){
        return this.precos.get(tipo);
    }

    public Double getNutricional(int tipo){
        return this.nutricional.get(tipo);
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    private void setupMap(){
        nomes.put(1, "Queijo");
        nomes.put(2, "Bigmac");
        nomes.put(3, "Bacon");

        precos.put(1, 10.0);
        precos.put(2, 11.0);
        precos.put(3, 12.0);

        nutricional.put(1, 1.0);
        nutricional.put(2, 2.0);
        nutricional.put(3, 3.0);
    }
}
