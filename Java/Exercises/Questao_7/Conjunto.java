package Questao_7;

import java.util.ArrayList;

public class Conjunto {
    private ArrayList<String> conjunto = new ArrayList<String>();

    public Conjunto(){

    }

    public Conjunto(Conjunto conjunto1){
        this.conjunto = conjunto1.getList();
    }

    public void addElement(String input){
        if(conjunto.contains(input) == false){
            this.conjunto.add(input);
        }
    }

    public String getElement(int number){
        return this.conjunto.get(number);
    }

    public String contains(String input){
        if(conjunto.contains(input) == true){
            return "Contains";
        } else{
            return "Does not contains";
        }
    }

    public Conjunto union(Conjunto conjunto1){
        Conjunto newConjunto = new Conjunto();
        for(int i = 0; i < this.conjunto.size(); i++){
            newConjunto.addElement(this.getElement(i));
        }
        for(int i = 0; i < conjunto1.getSize(); i++){
            newConjunto.addElement(conjunto1.getElement(i));
        }
        return newConjunto;
    }

    public ArrayList getList(){
        return this.conjunto;
    }

    public int getSize(){
        return this.conjunto.size();
    }

    public Conjunto inter(Conjunto conjunto1){
        Conjunto newConjunto = new Conjunto();

        if(this.getSize() > conjunto1.getSize() || this.getSize() == conjunto1.getSize()){
            for(int i = 0; i < this.getSize(); i++){
                if(conjunto1.getList().contains(this.getElement(i)) == true && newConjunto.getList().contains(this.getElement(i)) == false){
                    newConjunto.addElement(this.getElement(i));
                }
            }
        } else{
            for(int i = 0; i < conjunto1.getSize(); i++){
                if(this.conjunto.contains(conjunto1.getElement(i)) == true && newConjunto.getList().contains(conjunto1.getElement(i)) == false){
                    newConjunto.addElement(conjunto1.getElement(i));
                }
            }
        }
        return newConjunto;
    }

    public Conjunto menos(Conjunto conjunto1){
        Conjunto newConjunto = new Conjunto();

            for(int i = 0; i < this.getSize(); i++){
                if(conjunto1.getList().contains(this.getElement(i)) == false && newConjunto.getList().contains(this.getElement(i)) == false){
                    newConjunto.addElement(this.getElement(i));
                }
            }
        return newConjunto;
    }

    public void print(){
        for(int i = 0; i < this.getSize(); i++){
            System.out.printf("%s ", this.getElement(i));
        }
        System.out.println("");
    }
}
