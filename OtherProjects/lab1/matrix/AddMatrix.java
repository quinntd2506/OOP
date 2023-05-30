import java.util.Scanner;

public class AddMatrix {
    public static void main(String[] args) {
        // Input matrices size n x m
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // matrix 1
        double[][] a = new double[n][m];
        // matrix 2
        double[][] b = new double[n][m];
        // matrix sum
        double[][] c = new double[n][m];

        for( int i = 0 ; i<n ; i++)
            for( int j = 0 ; j<m ; j++){
                a[i][j] = scanner.nextDouble();
            }
        
        for( int i = 0 ; i<n ; i++)
            for( int j = 0 ; j<m ; j++){
                b[i][j] = scanner.nextDouble();
            }
        for( int i = 0 ; i<n ; i++)
            for( int j = 0 ; j<m ; j++){
                c[i][j] = a[i][j]+b[i][j];
            }
        
        System.out.println("Matrix 1:");
        printMatrix(a);
        System.out.println("Matrix 2:");
        printMatrix(b);
        System.out.println("Matrix Sum:");
        printMatrix(c);
    }

    // Utility method to print a matrix
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
