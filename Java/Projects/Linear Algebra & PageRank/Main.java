public class Main {
    public static void main(String[] args) {

        //Vector vetor1 = new Vector(new double[]{1, 2, 5, 3, 6});
        Matrix adjacencia = new Matrix(3, 3, new double[]{0,0,1,
                                                                    1,0,1,
                                                                    1,0,1});

        LinearAlgebra linear = new LinearAlgebra();

        linear.pageRank(adjacencia);
    }
}
