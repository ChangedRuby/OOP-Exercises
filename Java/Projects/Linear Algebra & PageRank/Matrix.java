public class Matrix {
    private double[][] matrix;
    int rows; int cols;

    public Matrix(){

    }

    public Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
    }

    public Matrix(int rows, int cols, double[] elements) {
        this.rows = rows;
        this.cols = cols;

        matrix = new double[rows][cols];
        int index = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                matrix[r][c] = elements[index++];
            }
        }
    }

    public void setMatrix(int rows, int cols, double[] elements) {
        this.rows = rows;
        this.cols = cols;

        matrix = new double[rows][cols];
        int index = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                matrix[r][c] = elements[index++];
            }
        }
    }

    public void setMatrix(int rows, int cols, int[] elements) {
        this.rows = rows;
        this.cols = cols;

        matrix = new double[rows][cols];
        int index = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                matrix[r][c] = elements[index++];
            }
        }
    }

    public void setMatrix(double[][] matrix){
        this.matrix = matrix;
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            if(i == 0 || i == matrix.length - 1) {
                System.out.printf("[ ");
            } else{
                System.out.printf("| ");
            }

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            if(i == 0 || i == matrix.length - 1) {
                System.out.println("]");
            } else{
                System.out.println("|");
            }
        }
    }
    public int getRowCount() {
        return rows;
    }
    public int getColCount() {
        return cols;
    }
    public double[][] getMatrix() {
        return matrix;
    }
    public double get(int i, int j) {
        return matrix[i][j];
    }
    public void set(int i, int j, double value) {
        matrix[i][j] = value;
    }
}