import java.util.Scanner;

public class ArrayInsertion
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Making an array
        int[] LA = {10, 20, 30, 40, 50};
        int size = LA.length;
        // Taking input from user
        System.out.print("Enter the index K (0 to " + (size - 1) + "): ");
        int K = scanner.nextInt();
        // Checking if K is within range
        if (K < 0 || K >= size)
        {
            System.out.println("Index K is out of range.");
            return;
        }
        System.out.print("Enter a positive integer: ");
        int ITEM = scanner.nextInt();

        // Check if ITEM is a positive integer or not
        if (ITEM <= 0) {
            System.out.println("ITEM must be a positive integer.");
            return;
        }
        // Compare ITEM with the value at index K
        if (ITEM < LA[K]) {
            // Insert ITEM into the array at index K
            LA[K] = ITEM;
            System.out.println("Entered ITEM is inserted at index " + K);
        }
        else
        {
            System.out.println("ITEM at index " + K + " is greater than user's entered ITEM.");
        }
        // Print the updated array
        System.out.print("Updated array: ");
        for (int value : LA) {
            System.out.print(value + " ");
        }
    }
}