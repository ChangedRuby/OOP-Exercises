public class Transformations extends LinearAlgebra{

    // reflection
    public Vector reflection2DX(Vector vector){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{1, 0, 0,
                                                                        0, -1, 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector reflection2DY(Vector vector){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{-1, 0, 0,
                                                                        0, 1, 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector reflection3DX(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{-1, 0, 0, 0,
                                                                        0, 1, 0, 0,
                                                                        0, 0, 1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector reflection3DY(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, 0,
                                                                        0, -1, 0, 0,
                                                                        0, 0, 1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector reflection3DZ(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, 0,
                                                                        0, 1, 0, 0,
                                                                        0, 0, -1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    // projection
    public Vector projection2DX(Vector vector){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{1, 0, 0,
                                                                        0, 0, 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector projection2DY(Vector vector){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{0, 0, 0,
                                                                        0, 1, 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector projection3DX(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{0, 0, 0, 0,
                                                                        0, 1, 0, 0,
                                                                        0, 0, 1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector projection3DY(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, 0,
                                                                        0, 0, 0, 0,
                                                                        0, 0, 1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector projection3DZ(Vector vector){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, 0,
                                                                        0, 1, 0, 0,
                                                                        0, 0, 0, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector);
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector rotate2D(Vector vector, double angle){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{Math.cos(angle), -1 * Math.sin(angle), 0,
                                                                        Math.sin(angle), Math.cos(angle), 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector rotate3DX(Vector vector, double angle) {
        if (vector.length() == 3) {
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, 0,
                                                                        0, Math.cos(angle), -1 * Math.sin(angle), 0,
                                                                        0, Math.sin(angle), Math.cos(angle), 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else {
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector rotate3DY(Vector vector, double angle) {
        if (vector.length() == 3) {
            Matrix canonica = new Matrix(4, 4, new double[]{Math.cos(angle), 0, Math.sin(angle), 0,
                                                                        0, 1, 0, 0,
                                                                        -1 * Math.sin(angle), 0, Math.cos(angle), 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else {
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector rotate3DZ(Vector vector, double angle) {
        if (vector.length() == 3) {
            Matrix canonica = new Matrix(4, 4, new double[]{Math.cos(angle), 0, -1 * Math.sin(angle), 0,
                                                                        Math.sin(angle), Math.cos(angle), 0, 0,
                                                                        0, 0, 1, 0,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else {
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector translation2D(Vector vector, double dx, double dy){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{1, 0, dx,
                                                                        0, 1, dy,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector translation3D(Vector vector, double dx, double dy, double dz){
        if(vector.length() == 3){
            Matrix canonica = new Matrix(4, 4, new double[]{1, 0, 0, dx,
                                                                        0, 1, 0, dy,
                                                                        0, 0, 1, dz,
                                                                        0, 0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }

    public Vector shearing(Vector vector, double kx, double ky){
        if(vector.length() == 2){
            Matrix canonica = new Matrix(3, 3, new double[]{1, kx, 0,
                                                                        ky, 1, 0,
                                                                        0, 0, 1});

            return this.dot(canonica, vector.c2h()).h2c();
        } else{
            System.out.println("Dimensao invalido");
            return null;
        }
    }
}
