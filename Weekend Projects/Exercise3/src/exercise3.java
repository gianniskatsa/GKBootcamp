import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        System.out.println("Welcome to the terminal app, please add 3 Bootcamps");
        Scanner input = new Scanner(System.in);
        List<BootCamp> BootCamps = new ArrayList();

        for (int i = 0; i < 3; i++) {
            BootCamp newBootCamps = new BootCamp();

            System.out.println("Enter details for the Bootcamp number: " + (i + 1));

            System.out.println("Enter Name: ");
            newBootCamps.setName(input.next());

            System.out.println("Enter Starting Date as yyyy-MM-dd: ");
            newBootCamps.setStartingDate();

            System.out.println("Enter Ending Date as yyyy-MM-dd:");
            newBootCamps.setEndingDate();

            BootCamps.add(newBootCamps);
        }
        System.out.println("Please enter a date to see if a Bootcamp is available: ");
        BootCamp userDateBootcamp = new BootCamp();
        userDateBootcamp.setCheckDate();
        for (BootCamp BootCamp : BootCamps) {

            if (userDateBootcamp.getCheckDate().compareTo(BootCamp.getStartingDate()) >= 0
                    && userDateBootcamp.getCheckDate().compareTo(BootCamp.getEndingDate()) < 1) {
                System.out.println("The Bootcamp " + BootCamp.getName() + " will be available in "
                        + userDateBootcamp.getCheckDate() + "." + "The Bootcamp begins at "
                        + BootCamp.getStartingDate() + " and ends at " + BootCamp.getEndingDate());
            } else {
                System.out.println("A Bootcamp is not available at " + userDateBootcamp.getCheckDate() + "\n");
            }
        }
    }
}


