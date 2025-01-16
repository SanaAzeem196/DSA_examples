import java.util.Scanner;

public class DiagonalSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix (n x n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int leftDiagonalSum = calculateLeftDiagonalSum(matrix);
        int rightDiagonalSum = calculateRightDiagonalSum(matrix);

        System.out.println("Left diagonal sum: " + leftDiagonalSum);
        System.out.println("Right diagonal sum: " + rightDiagonalSum);
    }

    public static int calculateLeftDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int calculateRightDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }
}