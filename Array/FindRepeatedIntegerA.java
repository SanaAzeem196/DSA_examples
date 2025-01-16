import java.util.Scanner;

public class FindRepeatedIntegerA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array A (n ≥ 2): ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        System.out.println("Enter " + n + " integers (from 1 to " + (n - 1) + "):");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int repeated = findRepeated(A);
        System.out.println("The repeated integer in array A is: " + repeated);
    }

    public static int findRepeated(int[] A) {
        boolean[] seen = new boolean[A.length];
        for (int num : A) {
            if (seen[num]) {
                return num;
            }
            seen[num] = true;
        }
        return -1; // This line should never be reached if input is valid
    }
}