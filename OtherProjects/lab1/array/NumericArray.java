import java.util.Arrays;
import java.util.Scanner;

public class NumericArray {
    public static void main(String[] args) {
        // Input array
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = keyboard.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextInt();
        }
        keyboard.close();
        
        /*System.out.println("The array elements are:");
        for (int number : arr) {
            System.out.printf(number + " ");
        }*/
        
        // Sort the array
        Arrays.sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Calculate sum of array elements
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of Array Elements: " + sum);

        // Calculate average of array elements
        double average = (double) sum / n;
        System.out.println("Average of Array Elements: " + average);
    }
}
