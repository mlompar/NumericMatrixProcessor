package processor;

import java.util.Scanner;

public class Main {
    private static void main_prompt() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static void transpose_prompt() {
        System.out.println();
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
    }


    private static void printError() {
        System.out.println("The result is:");
        System.out.printf("ERROR");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            int n, nb, m, mb, k;
            double[][] a, b, c;
            main_prompt();
            switch (scanner.nextInt()) {
                case 1:
                    // read a
                    System.out.print("Enter size of first matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println("Enter first matrix:");
                    a = new double[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[i][j] = scanner.nextDouble();
                        }
                    }
                    // read b and check if can addMatrix
                    System.out.print("Enter size of second matrix: ");
                    nb = scanner.nextInt();
                    mb = scanner.nextInt();
                    System.out.println("Enter second matrix: ");
                    b = new double[nb][mb];
                    for (int i = 0; i < nb; i++) {
                        for (int j = 0; j < mb; j++) {
                            b[i][j] = scanner.nextDouble();
                        }
                    }
                    if (nb == n && mb == m) {
                        c = processor.Matrix.addMatrix(a, b);
                        processor.Matrix.printMatrix(c);
                    } else {
                        printError();
                    }
                    break;

                case 2:
                    // read a
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println("Enter matrix:");
                    a = new double[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[i][j] = scanner.nextDouble();
                        }
                    }
                    // read constant
                    System.out.print("Enter constant value: ");
                    double cnst = scanner.nextDouble();
                    c = processor.Matrix.multipyMatrixWithConstant(a, cnst);
                    processor.Matrix.printMatrix(c);
                    break;

                case 3:
                    // read a
                    System.out.print("Enter size of first matrix: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println("Enter first matrix:");
                    a = new double[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[i][j] = scanner.nextDouble();
                        }
                    }
                    // read b and check if nxm mxk
                    System.out.print("Enter size of second matrix: ");
                    mb = scanner.nextInt();
                    k = scanner.nextInt();
                    System.out.println("Enter second matrix:");
                    b = new double[mb][k];
                    for (int i = 0; i < mb; i++) {
                        for (int j = 0; j < k; j++) {
                            b[i][j] = scanner.nextDouble();
                        }
                    }
                    System.out.println("The result is:");
                    if (mb != m) {
                        System.out.println("ERROR");
                    } else {
                        // multiply
                        c = new double[n][k];
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < k; j++) {
                                for (int kk = 0; kk < m; kk++) {
                                    c[i][j] += a[i][kk] * b[kk][j];
                                }
                                System.out.print(c[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                    break;

                case 4:
                    transpose_prompt();
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.print("Enter matrix size: ");
                            n = scanner.nextInt();
                            m = scanner.nextInt();
                            System.out.println("Enter matrix:");
                            a = new double[n][m];
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < m; j++) {
                                    a[i][j] = scanner.nextDouble();
                                }
                            }
                            if (m != n) {
                                printError();
                            } else {
                                processor.Matrix.transposeMatrix(a);
                                processor.Matrix.printMatrix(a);
                            }
                            break;
                        case 2:
                            System.out.print("Enter matrix size: ");
                            n = scanner.nextInt();
                            m = scanner.nextInt();
                            System.out.println("Enter matrix:");
                            a = new double[n][m];
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < m; j++) {
                                    a[i][j] = scanner.nextDouble();
                                }
                            }
                            if (m != n) {
                                printError();
                            } else {
                                processor.Matrix.flipMatrixVertical(a);
                                processor.Matrix.flipMatrixHorizontal(a);
                                processor.Matrix.transposeMatrix(a);
                                processor.Matrix.printMatrix(a);
                            }
                            break;
                        case 3:
                            System.out.print("Enter matrix size: ");
                            n = scanner.nextInt();
                            m = scanner.nextInt();
                            System.out.println("Enter matrix:");
                            a = new double[n][m];
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < m; j++) {
                                    a[i][j] = scanner.nextDouble();
                                }
                            }
                            processor.Matrix.flipMatrixVertical(a);
                            processor.Matrix.printMatrix(a);
                            break;
                        case 4:
                            System.out.print("Enter matrix size: ");
                            n = scanner.nextInt();
                            m = scanner.nextInt();
                            System.out.println("Enter matrix:");
                            a = new double[n][m];
                            for (int i = 0; i < n; i++) {
                                for (int j = 0; j < m; j++) {
                                    a[i][j] = scanner.nextDouble();
                                }
                            }
                            processor.Matrix.flipMatrixHorizontal(a);
                            processor.Matrix.printMatrix(a);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    // read a
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println("Enter matrix:");
                    a = new double[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[i][j] = scanner.nextDouble();
                        }
                    }
                    if (n != m) {
                        printError();
                    } else {
                        System.out.println("The result is:");
                        System.out.println(processor.Matrix.determinantOfMatrix(a));
                        System.out.println();
                    }
                    break;
                case 6:
                    // read a
                    System.out.print("Enter matrix size: ");
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    System.out.println("Enter matrix:");
                    a = new double[n][m];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            a[i][j] = scanner.nextDouble();
                        }
                    }
                    if (Matrix.determinantOfMatrix(a) == 0) {
                        printError();
                    } else {
                        Matrix.printMatrix(Matrix.inverseMatrix(a));
                    }
                    break;
                case 0:
                default:
                    exit = true;
                    break;
            }
        }
    }
}
