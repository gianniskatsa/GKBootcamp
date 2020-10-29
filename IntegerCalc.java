
import java.util.Scanner;

public class IntegerCalc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = s.nextInt();
        System.out.println("Select Between + , - , * , / ");
        String praksi = s.next();
        System.out.println("Enter the second number:");
        int num2 = s.nextInt();
        if (praksi.contains("+")) {
            System.out.println("Your result is " + (num1 + num2));
        }
    }
}