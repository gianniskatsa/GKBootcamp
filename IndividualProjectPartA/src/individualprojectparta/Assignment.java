package individualprojectparta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


public class Assignment {

    private String title;
    private String description;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public Assignment(String title, String description, String subDateTime, int oralMark, int totalMark) {

        this.title = title;
        this.description = description;
        this.subDateTime = LocalDate.parse(subDateTime, formatter);
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public Assignment() {
    }

    public LocalDate getSubDateTime() {

        return subDateTime;
    }

    public void setSubDateTime() {
        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String inp = scanner.next();
                this.subDateTime = LocalDate.parse(inp, formatter);
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }

        } while (flag1);
    }


    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark() {
        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                int inp = scanner.nextInt();
                this.oralMark =inp;
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        }while(flag1);

    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark() {
        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                int inp = scanner.nextInt();
                this.totalMark =inp;
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        }while(flag1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }


}
