import javax.swing.*;

public class LinearAlgebra {
    Matrix matrix = new Matrix();
    private int rows;
    private int cols;
    private int dim;
    private double[][] transposedMatrix;
    private double[] transposedVector;

    public void transpose(double[][] mainMatrix) {
        cols = mainMatrix[0].length;
        rows = mainMatrix.length;
        transposedMatrix = new double[cols][rows];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = mainMatrix[i][j];
            }
        }
    }

    public Matrix transpose(Matrix mainMatrix) {
        cols = mainMatrix.getColCount();
        rows = mainMatrix.getRowCount();
        Matrix newMatrix = new Matrix(cols, rows);
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix.set(j, i, mainMatrix.get(i , j));
            }
        }
        return newMatrix;
    }

    public void vectorTranpose(double[] mainVector) {
        dim = mainVector.length;
        transposedVector = new double[dim];
        for (int i = 0; i < dim; i++) {
                transposedVector[i] = mainVector[dim - i - 1];
        }
    }
    public void printMatrix() {
        for(int i = 0; i < transposedMatrix.length; i++) {
            for(int j = 0; j < transposedMatrix[i].length; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printVector() {
        for(int i = 0; i < transposedVector.length; i++) {
            System.out.print(transposedVector[i] + " ");
        }
    }

    public Matrix add(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowCount() != matrix2.getRowCount() || matrix1.getColCount() != matrix2.getColCount()) {
            System.out.print("As matrizes não tem o mesmo tamanho, impóssivel realizar a operação.");
            return null;
        }
        double[][] result = new double[matrix1.getRowCount()][matrix1.getColCount()];
        for (int i = 0; i < matrix1.getRowCount(); i++) {
            for(int j = 0; j < matrix1.getColCount(); j++) {
                result[i][j] = matrix1.get(i, j) + matrix2.get(i, j);
            }
        }

        Matrix resultMatrix = new Matrix();
        resultMatrix.setMatrix(matrix1.getRowCount(), matrix1.getColCount(), flatten(result));
        return resultMatrix;
    }

    private double[] flatten(double[][] array) {
        double[] result = new double[array.length * array[0].length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[index++] = array[i][j];
            }
        }
        return result;
    }

    public Vector add(Vector vector1, Vector vector2) {
        if (vector1.length() != vector2.length()) {
            System.out.println("Os vetores não tem o mesmo tamanho, impóssivel realizar a operação.");
            return null;
        }
        double[] result = new double[vector1.length()];
        for (int i = 0; i < vector1.length(); i++) {
            result[i] = vector1.get(i) + vector2.get(i);
        }

        Vector resultVector = new Vector(vector1.length(), result);
        return resultVector;
    }

    public Matrix times(Matrix matrix1, Matrix matrix2) {
        if(matrix1.getRowCount() != matrix2.getRowCount() || matrix1.getColCount() != matrix2.getColCount()) {
            System.out.print("As matrizes não tem o mesmo tamanho, impóssivel realizar a operação.");
            return null;
        }
        double[][] result = new double[matrix1.getRowCount()][matrix1.getColCount()];
        for (int i = 0; i < matrix1.getRowCount(); i++) {
            for (int j = 0; j < matrix1.getColCount(); j++) {
                result[i][j] = matrix1.get(i, j) * matrix2.get(i, j);
            }
        }
        Matrix resultMatrix = new Matrix();
        resultMatrix.setMatrix(matrix1.getRowCount(), matrix1.getColCount(), flatten(result));
        return resultMatrix;
    }

    // matrix multiplied by vector
    public Vector dot(Matrix matrix, Vector vector){
        Vector resultVector = new Vector(matrix.getRowCount());
        if(vector.length() == matrix.getColCount()) {
            for(int i = 0; i < matrix.getRowCount(); i++) {
                for(int j = 0; j < matrix.getColCount(); j++) {
                    resultVector.set(i, resultVector.get(i) + matrix.get(i, j) * vector.get(j));
                }
            }
        } else{
            System.out.println("A matriz não tem a mesma quantidade de colunas que a de componentes do vetor");
            return null;
        }
        return resultVector;
    }


    public Matrix timesScalar(Matrix matrix, double scalar) {
        double[][] resultElements = new double[matrix.getRowCount()][matrix.getColCount()];
        for (int i = 0; i < matrix.getRowCount(); i++) {
            for (int j = 0; j < matrix.getColCount(); j++) {
                resultElements[i][j] = matrix.get(i, j) * scalar;
            }
        }
        Matrix resultMatrix = new Matrix();
        resultMatrix.setMatrix(matrix.getRowCount(), matrix.getColCount(), flatten(resultElements));
        return resultMatrix;
    }

    public Vector times(Vector vector1, Vector vector2) {
        if(vector1.length() != vector2.length()) {
            System.out.print("Os vetores não tem o mesmo tamanho, impóssivel realizar a operação.");
        }
        double[] result = new double[vector1.length()];
        for(int i = 0; i < vector1.length(); i++) {
            result[i] = vector1.get(i) * vector2.get(i);
        }

        Vector resultVector = new Vector(result);
        resultVector.setVector(result);
        return resultVector;
    }

    public Vector timesScalar(Vector vector, double scalar) {
        double[] resultElements = new double[vector.length()];
        for (int i = 0; i < vector.length(); i++) {
            resultElements[i] = vector.get(i) * scalar;
        }
        Vector resultVector = new Vector();
        resultVector.setVector(resultElements);
        return resultVector;
    }

    public Matrix dot(Matrix matrix1, Matrix matrix2) {
        if(matrix1.getColCount() != matrix2.getRowCount()) {
            System.out.print("A quantidade de linhas da Matriz 1 não coincide com a quantidade de colunas da Matriz 2, impóssivel realizar a operação.");
        }
        double[][] result = new double[matrix1.getRowCount()][matrix2.getColCount()];
        for(int i = 0; i < matrix1.getRowCount(); i++) {
            for(int j = 0; j < matrix2.getColCount(); j++) {
                for(int k = 0; k < matrix1.getColCount(); k++) {
                    result[i][j] += matrix1.get(i, k) * matrix2.get(k, j);
                }
            }
        }

        Matrix resultMatrix = new Matrix();
        resultMatrix.setMatrix(matrix1.getRowCount(), matrix2.getColCount(), flatten(result));
        return resultMatrix;
    }

    public void pageRank(Matrix adjacencia){
        Vector centro = new Vector(adjacencia.getColCount());
        double result = 0;

        // calcula o vetor centro
        for(int i = 0; i < adjacencia.getColCount(); i++){
            result = 0;
            for(int j = 0; j < adjacencia.getRowCount(); j++){
                result += adjacencia.get(j, i);
            }
            centro.set(i, result);
        }

        Vector resultVector = new Vector();
        resultVector.setVector(calcPageRank(adjacencia.getColCount() * 2, adjacencia, centro));

        System.out.println("Resultados do Page Rank: ");
        for(int i = 0; i < resultVector.length(); i++){
            System.out.printf("Ranqueamento do site %d: %.2f\n", i + 1, resultVector.get(i));
        }

        System.out.println("Vetor dos resultados ordenados decrescente: ");
        resultVector.reverseSortVector();
        resultVector.printVector();
    }

    public Vector calcPageRank(int iterations, Matrix adjacencia, Vector pesos){
        if(iterations == 0){
            return pesos;
        } else{
            //System.out.println((this.dot(this.dot(this.transpose(adjacencia), adjacencia), pesos).modulo()));
            return calcPageRank(iterations - 1, adjacencia, this.timesScalar((this.dot(this.dot(this.transpose(adjacencia), adjacencia), pesos)), (1 / (this.dot(this.dot(this.transpose(adjacencia), adjacencia), pesos).modulo()))));
        }
    }

    public void printVector(Vector vector) {
        if(vector != null){
            System.out.print("[ ");
            for(int i = 0; i < vector.length(); i++) {
                System.out.printf("%.2f ", vector.get(i));
            }
            System.out.println("]");
        } else{
            JOptionPane.showMessageDialog(null, "Vetor de tamanho invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Matrix gauss(Matrix matrix) {
        int rows = matrix.getRowCount();
        int cols = matrix.getColCount();
        for(int i = 0; i < rows; i++) {
            int maxRow = i;
            for(int k = i + 1; k < rows; k++) {
                if(matrix.get(k, i) > matrix.get(maxRow, i)) {
                    maxRow = k;
                }
            }
            if(maxRow != i) {
                swapRows(matrix, i, maxRow);
            }
            double pivot = matrix.get(i, i);
            for(int k = i + 1; k < rows; k++) {
                double c = -matrix.get(k, i) / pivot;
                eliminateRow(matrix, k, i, c);
            }
            for(int k = i; k < cols; k++) {
                matrix.set(i, k, (int) (matrix.get(i, k) / pivot));
            }
        }
        return matrix;
    }

    public void swapRows(Matrix matrix, int i, int j) {
        for(int k = 0; k < matrix.getColCount(); k++) {
            double temp = matrix.get(i, k);
            matrix.set(i, j, matrix.get(j, k));
            matrix.set(j, k, temp);
        }
    }
    private void eliminateRow(Matrix matrix, int i, int j, double c) {
        //double pivot = matrix.get(j, j);
        for (int k = j; k < matrix.getColCount(); k++) {
            double val = (double) matrix.get(i, k) + c * (double) matrix.get(j, k);
            matrix.set(i, k, (int) val);
        }
        matrix.set(i, j, 0);
    }
}