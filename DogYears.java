import java.util.Scanner;

public class DogYears {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("How old is your dog");
        int dogYears = s.nextInt();

        if (dogYears <= 2 && dogYears  != 0 ) {
            System.out.println("Your dog is" + dogYears + "years old in human years");
        } 
        
        else if (dogYears == 0) {
            System.out.println("This is an error, please enter a different age for your dog");
        } 
        
        else if (dogYears > 30) {
            System.out.println("This is an error, please enter a different age for your dog");
        } 
        
        else {
            int humanYears =  ((dogYears - 2) * 5) +2 ;
            System.out.println("Your dog is " + humanYears + " years old in human years");
        }
    }
}
