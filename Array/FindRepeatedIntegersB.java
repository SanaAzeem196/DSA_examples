import java.util.Scanner;

public class FindRepeatedIntegersB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array B (n ≥ 6): ");
        int n = scanner.nextInt();
        int[] B = new int[n];

        System.out.println("Enter " + n + " integers (from 1 to " + (n - 5) + "):");
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        findRepeated(B);
    }

    public static void findRepeated(int[] B) {
        boolean[] seen = new boolean[B.length];
        int count = 0;

        System.out.println("The repeated integers in array B are:");
        for (int num : B) {
            if (seen[num]) {
                System.out.println(num);
                count++;
                if (count == 5) {
                    break;
                }
            }
            seen[num] = true;
        }
    }
}