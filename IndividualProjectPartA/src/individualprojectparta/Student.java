package individualprojectparta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.lang.*;
import java.util.Scanner;


public class Student {
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double tuitionFees;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);



    public Student(String fNa, String lNa, String date, double tFe, List<Assignment> assignments) {
        this.firstName = fNa;
        this.lastName = lNa;
        this.dateOfBirth = LocalDate.parse(date, formatter);
        this.tuitionFees = tFe;
        this.assignments = assignments;
    }
    public Student(){}
    List<Assignment> assignments;

    public List<Assignment> getAssignmentsFromStudents() {
        return assignments;
    }



    public void setDateOfBirth() {

        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String inp= scanner.next();
                this.dateOfBirth = LocalDate.parse(inp, formatter);
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }

        } while (flag1);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        if (this.lastName.equals(other.lastName)
                && this.firstName.equals(other.firstName)
        ) {
            return true;
        } else {
            return false;
        }
    }

}