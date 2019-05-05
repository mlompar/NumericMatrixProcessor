package processor;

public class Matrix {
    public static void printMatrix(double[][] matrix) {
        System.out.println("The result is:");
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                System.out.printf("%5.2f ", matrix[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {
        int n = a.length;
        int m = a[0].length;
        double[][] c = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static double[][] multipyMatrixWithConstant(double[][] matrix, double constant) {
        int n = matrix.length;
        int m = matrix[0].length;
        double[][] product = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                product[i][j] = constant * matrix[i][j];
            }
        }
        return product;
    }

    public static void transposeMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (i != j) {
                    double tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    public static void flipMatrixHorizontal(double[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                double tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = tmp;
            }
        }
    }

    public static void flipMatrixVertical(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                double tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = tmp;
            }
        }
    }

    public static double cofactor(double[][] matrix, int i, int j) {
        int minorSize = matrix.length - 1;
        double[][] minor = new double[minorSize][minorSize];
        int skipRow;
        int skipColumn;
        for (int jMinor = 0; jMinor < minorSize; jMinor++) {
            if (jMinor < j) {
                skipRow = 0;
            } else {
                skipRow = 1;
            }
            for (int iMinor = 0; iMinor < minorSize; iMinor++) {
                if (iMinor < i) {
                    skipColumn = 0;
                } else {
                    skipColumn = 1;
                }
                minor[jMinor][iMinor] = matrix[jMinor + skipRow][iMinor + skipColumn];
            }
        }
        return Math.pow(-1, 2 + j + i) * determinantOfMatrix(minor);
    }

    public static double determinantOfMatrix(double[][] matrix) {
        double result = 0;

        int size = matrix.length;

        // exit condition is 2d matrix
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // reduce matrix by first row
        int jMatrix = 0;
        for (int iMatrix = 0; iMatrix < size; iMatrix++) {
            result += matrix[jMatrix][iMatrix] * cofactor(matrix, iMatrix, jMatrix);
        }

        return result;
    }

    public static double[][] adjointMatrix(double[][] matrix) {
        double[][] adjoint = new double[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[0].length; i++) {
                adjoint[j][i] = cofactor(matrix, i, j);
            }
        }
        Matrix.transposeMatrix(adjoint);
        return adjoint;
    }

    public static double[][] inverseMatrix(double[][] matrix) {
        double det = determinantOfMatrix(matrix);
        System.out.println("det = " + det);
        double[][] adjoint = adjointMatrix(matrix);
        return multipyMatrixWithConstant(adjoint, 1.0 / det);
    }
}
