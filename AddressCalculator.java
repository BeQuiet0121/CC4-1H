import java.util.Scanner;

public class AddressCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the number of dimensions: ");
        int dimensions = scanner.nextInt();

        System.out.print("Enter the base address: ");
        int baseAddress = scanner.nextInt();

        System.out.print("Enter the element size: ");
        int elementSize = scanner.nextInt();

        int[] upperBounds = new int[dimensions];
        System.out.println("Enter the upper bounds for each dimension:");
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Upper bound for dimension " + (i + 1) + ": ");
            upperBounds[i] = scanner.nextInt();
        }

        int[] targetElement = new int[dimensions];
        System.out.println("Enter the target element for each dimension:");
        for (int i = 0; i < dimensions; i++) {
            System.out.print("Target element for dimension " + (i + 1) + ": ");
            targetElement[i] = scanner.nextInt();
        }

        // Calculate the array address
        int arrayAddress = baseAddress;
        for (int i = 0; i < dimensions; i++) {
            int stride = 1;
            for (int j = i + 1; j < dimensions; j++) {
                stride *= (upperBounds[j]);
            }
            arrayAddress += targetElement[i] * stride * elementSize;
        }

        // Display the result
        System.out.println("The array address of the target element is: " + arrayAddress);
    }
}
    