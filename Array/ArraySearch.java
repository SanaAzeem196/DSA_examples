import java.util.Scanner;

public class ArraySearch
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] LA = {10, 20, 30, 40, 50, 60, 70};

        System.out.print("Enter an integer ITEM to search: ");
        int ITEM = scanner.nextInt();

        search(LA, ITEM);
    }

    public static void search(int[] LA, int ITEM) {
        boolean found = false;
        int index = -1;

        for (int i = 0; i < LA.length; i++) {
            if (LA[i] == ITEM) {
                found = true;
                index = i;
                break;
            }
        }

        if (found) {
            System.out.println("ITEM " + ITEM + " found at index " + index + ".");
            System.out.print("Right neighbors: ");
            if (index + 1 < LA.length) {
                System.out.print(LA[index + 1]);
                if (index + 2 < LA.length) {
                    System.out.print(", " + LA[index + 2]);
                } else {
                    System.out.print(" (no second right neighbor)");
                }
            } else {
                System.out.print("no right neighbor");
            }
            System.out.println();

            System.out.print("Left neighbors: ");
            if (index - 1 >= 0) {
                System.out.print(LA[index - 1]);
                if (index - 2 >= 0) {
                    System.out.print(", " + LA[index - 2]);
                } else {
                    System.out.print(" (no second left neighbor)");
                }
            } else {
                System.out.print("no left neighbor");
            }
            System.out.println();
        } else {
            System.out.println("ITEM " + ITEM + " not found in the array.");
        }
    }
}