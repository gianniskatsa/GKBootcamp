import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BootCamp {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    String name = null;
    LocalDate startingDate;
    LocalDate endingDate;
    private LocalDate checkDate;

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String line = scanner.next();
                this.endingDate = LocalDate.parse(line, formatter);
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        } while (flag1);
    }


    public void setStartingDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        boolean flag;
        do{
        try {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.next();
            this.startingDate = LocalDate.parse(line, formatter);
            flag=false;
        } catch (Exception e) {
            System.err.println("Invalid date value. ");
            System.out.println("Please enter a new one:");
            flag=true;
        }
        }while(flag);
    }

    public LocalDate getStartingDate() {
        return startingDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        boolean flag;
        do{
            try {
                Scanner scanner = new Scanner(System.in);
                String line = scanner.next();
                this.checkDate = LocalDate.parse(line, formatter);
                flag=false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one:");
                flag=true;
            }
        }while(flag);
    }
}