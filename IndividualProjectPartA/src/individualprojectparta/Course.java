package individualprojectparta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Course {
    private String courseTitle;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    List<Trainer> trainers;
    List<Student> students;
    List<Assignment> assignments;

    public Course(String courseTitle, String stream, String type, String startDate, String EndDate, List<Trainer> trainers, List<Student> students, List<Assignment> assignments) {
        this.courseTitle = courseTitle;
        this.stream = stream;
        this.type = type;
        this.startDate = LocalDate.parse(startDate, formatter);
        this.endDate = LocalDate.parse(EndDate, formatter);
        this.trainers = trainers;
        this.students = students;
        this.assignments = assignments;

    }

    public Course() {
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return startDate;
    }

    public void setStartDate() {
        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String inp = scanner.next();
                this.startDate = LocalDate.parse(inp, formatter);
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }

        } while (flag1);

    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate() {

        boolean flag1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String inp = scanner.next();
                this.endDate = LocalDate.parse(inp, formatter);
                flag1 = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }

        } while (flag1);

    }
}
