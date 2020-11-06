import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length = s.nextInt();
        int [] Array = new int[length];
        System.out.println("Enter the elements of the array:");

        for(int i=0; i<length; i++ ) {
            Array[i] = s.nextInt();
        }


        Arrays.sort(Array);

        System.out.printf("My Sorted Array is : %s",
                Arrays.toString(Array));
    }
} 