import javax.swing.*;

public class Vector {
    private double[] vector;

    public Vector() {

    }

    public Vector(int dim, double[] elements) {
        vector = new double[dim];
        int Index = 0;
        for(int i = 0; i < dim; i++) {
            if(Index < elements.length) {
                vector[i] = elements[Index++];
            }
        }
    }

    public Vector(int dim){
        vector = new double[dim];
    }

    public Vector(int dim, String[] elements) {
        vector = new double[elements.length];
        int Index = 0;
        for(int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[Index++]);
        }
    }

    public void setVector(double[] elements) {
        vector = new double[elements.length];
        int Index = 0;
        for(int i = 0; i < elements.length; i++) {
            vector[i] = elements[Index++];
        }
    }

    public void setVector(Vector vector){
        this.vector = new double[vector.length()];
        this.vector = vector.getVector();
    }

    public double modulo(){
        double result = 0;
        for(int i = 0; i < this.vector.length; i++) {
            result += this.vector[i] * this.vector[i];
        }
        return Math.sqrt(result);
    }

    public void sortVector(){
        double temp = 0;
        for(int i = 0; i < this.vector.length; i++) {
            for(int j = i+1; j < this.vector.length; j++) {
                if(this.vector[j] < this.vector[i]) {
                    temp = this.vector[j];
                    this.vector[j] = this.vector[i];
                    this.vector[i] = temp;
                }
            }
        }
    }

    public void reverseSortVector(){
        double temp = 0;
        for(int i = 0; i < this.vector.length; i++) {
            for(int j = i+1; j < this.vector.length; j++) {
                if(this.vector[j] > this.vector[i]) {
                    temp = this.vector[j];
                    this.vector[j] = this.vector[i];
                    this.vector[i] = temp;
                }
            }
        }
    }


    public void printVector() {
        if(vector != null){
            System.out.print("[ ");
            for(int i = 0; i < vector.length; i++) {
                System.out.printf("%.2f ", vector[i]);
            }
            System.out.println("]");
        } else{
            JOptionPane.showMessageDialog(null, "Vetor de tamanho invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Vector c2h(){
        Vector newVector = new Vector(this.vector.length + 1, this.vector);
        newVector.set(newVector.length() - 1, 1);
        return newVector;
    }

    public Vector h2c(){
        Vector newVector = new Vector(this.vector.length - 1, this.vector);
        for(int i = 0; i < newVector.length(); i++) {
            newVector.set(i, newVector.get(i) / this.vector[this.vector.length - 1]);
        }
        return newVector;
    }


    public double get(int i) {
        return vector[i];
    }
    public void set(int i, double value) {
        vector[i] = value;
    }
    public int length() {
        return vector.length;
    }
    public Vector(double[] vector) {
        this.vector = vector;
    }
    public double[] getVector() {
        return this.vector;
    }
}