import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        float number;
        boolean flag;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter a number between 1-10:  ");
                    number = sc.nextFloat();
                    flag = false;

                    if (number >= 1 && number <= 10) {
                        System.out.println("Your number is " + number);

                    } else if (number <= 0) {
                        System.err.println("Please enter a number between 1-10");
                        flag = true;

                    } else if (number > 11) {
                        System.err.println("Please enter a number between 1-10");
                        flag = true;
                    }

                } catch (Exception e) {
                    System.err.println("Enter only an integer between 1-10. ");
                    flag = true;
                }
            }
            while (flag);
    }
}

