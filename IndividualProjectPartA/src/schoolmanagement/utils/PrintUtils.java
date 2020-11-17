package schoolmanagement.utils;

import schoolmanagement.beans.Assignment;
import schoolmanagement.beans.Course;
import schoolmanagement.beans.Student;
import schoolmanagement.beans.Trainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintUtils {
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public static void printOptionCourses(List<Course> courses) {
        System.out.println("The courses available are:\n");
        for (Course course : courses) {
            System.out.println(course.getStream() + " " + course.getType()
                    + " starts at " + course.getStart_date() + " and ends at " + course.getEndDate());
        }
    }

    public static void printOptionDuplicateStudents(List<Student> javaStudents,
                                                    List<Student> sqlStudents,
                                                    List<Student> sqlStudentsPartTime,
                                                    List<Student> javaStudentsPartTime) {
        List<Student> duplicateStudents = new ArrayList<>(sqlStudents);
        duplicateStudents.retainAll(javaStudentsPartTime);
        List<Student> duplicateStudents2 = new ArrayList<>(javaStudents);
        duplicateStudents2.retainAll(sqlStudentsPartTime);
        List<Student> duplicateStudents3 = new ArrayList<>(sqlStudents);
        duplicateStudents3.retainAll(javaStudents);
        List<Student> duplicateStudents4 = new ArrayList<>(sqlStudentsPartTime);
        duplicateStudents4.retainAll(javaStudentsPartTime); //Trying out all the possible combinations and keeping lists of them all

        System.out.println("The students that participate in more than one courses are "
                + duplicateStudents + duplicateStudents2 + duplicateStudents3 + duplicateStudents4);
    }

    public static void printOptionAssignmentPerStudent(List<Student> javaStudents,
                                                       List<Student> sqlStudents,
                                                       List<Student> sqlStudentsPartTime,
                                                       List<Student> javaStudentsPartTime,
                                                       List<Student> newStudents) {
        for (Student student : javaStudents) {
            System.out.println("The student's name is " + student.getFirstName() + " "
                    + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignments());
        }
        for (Student student : javaStudentsPartTime) {
            System.out.println("The student's name is " + student.getFirstName() + " "
                    + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignments());
        }
        for (Student student : sqlStudents) {
            System.out.println("The student's name is " + student.getFirstName() +
                    " " + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignments());
        }
        for (Student student : sqlStudentsPartTime) {
            System.out.println("The student's name is " + student.getFirstName() +
                    " " + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignments());
        }
        if (!newStudents.isEmpty()) {
            for (Student student : newStudents) {
                System.out.println("The student's name is " + student.getFirstName() +
                        " " + student.getLastName() + " and these are the assignments he has to submit "
                        + student.getAssignments());

            }
        }
    }

    public static void printOptionAssignmentsPerCourse(List<Course> courses) {
        for (Course course : courses) {
            System.out.println("The course " + course.getCourseTitle() + " " + course.getStream() + " "
                    + course.getType() + " has the next assignments " + course.getAssignments());
        }
    }

    public static void printOptionAssignmentsAll(List<Assignment> javaAssignments,
                                                 List<Assignment> sqlAssignments,
                                                 List<Assignment> newAssignments) {


        for (Assignment assignment : javaAssignments) {
            System.out.println("The assignment's name is " + assignment.getTitle() +
                    " the assignment's submission date is " + assignment.getSubDateTime());
        }
        for (Assignment assignment : sqlAssignments) {
            System.out.println("The assignment's name is " + assignment.getTitle() +
                    " the assignment's submission date is " + assignment.getSubDateTime());
        }

        if (!newAssignments.isEmpty()) {
            for (Assignment assignment : newAssignments) {
                System.out.println("The assignment's name is " + assignment.getTitle() +
                        " the assignment's submission date is " + assignment.getSubDateTime());
            }
        }
    }

    public static void printOptionStudentsPerCourse(List<Course> courses) {
        for (Course course : courses) {
            System.out.println("The course " + course.getStream() + " with the type " +
                    course.getType() + " has the next students " + course.getStudents());
        }
    }

    public static void printOptionStudentsAll(List<Course> courses) {
        System.out.println("The Students studying at our school are");
        for (Course course : courses) {
            System.out.println(course.getStudents());
        }
    }

    public static void printOptionTrainersPerCourse(List<Course> courses, List<Trainer> javaTrainers,
                                                    List<Trainer> sqlTrainers,
                                                    List<Trainer> newTrainers) {
        System.out.println("Print all the trainers per course :");
        for (Course course : courses) {
            System.out.println("The trainers for the course " + course.getCourseTitle() + " "
                    + course.getStream() + " " + course.getType() + " are " + course.getTrainers());

        }
    }

    public static void printOptionTrainers(List<Trainer> javaTrainers,
                                           List<Trainer> newTrainers,
                                           List<Trainer> sqlTrainers) {
        System.out.println("The trainers available are:\n");

        for (Trainer trainer : javaTrainers) {
            System.out.println("The trainer's name is " + trainer.getLastName() + " " + trainer.getLastName());
        }
        for (Trainer trainer : sqlTrainers) {
            System.out.println("The trainer's name is " + trainer.getLastName() + " " + trainer.getLastName());
        }

        if (!newTrainers.isEmpty()) {
            for (Trainer trainer : newTrainers) {
                System.out.println("The trainer's name is " + trainer.getFirstName() +
                        " " + trainer.getLastName());

            }
        }
    }

    public static void startTheSecondPrints() {
        System.out.println("Choose between the next options: " + "\n" + "A) Print all the available courses"
                + "\n" + "B) Print all the available trainers" + "\n" + "C) Print the trainers per course" + "\n" +
                "D) Print all the students" + "\n" + "E) Print all the students per course" + "\n" +
                "F) Print all the assignments " + "\n" + "G) Print all the assignments per course" + "\n" +
                "H) Print all the assignments per students" + "\n" +
                "I) Print a list of students that belong to more than one Courses" + "\n" +
                "J) Submit a date to check if a student has an assignment to submit on that date" + "\n");
    }

    public static void startThePrints() {
        System.out.println("Welcome to our Private School's Command Prompt application" + "\n");
        System.out.println("Choose between the next options: " + "\n" + "A) Enter more courses" + "\n" +
                "B) Enter more students" + "\n" + "C) Enter more trainers" + "\n" +
                "D) Enter more assignments" + "\n" + "E) Do not enter input");
    }

    public static void printOptionCheckDateForAssignment(List<Assignment> javaAssignments,
                                                         List<Assignment> sqlAssignments,
                                                         List<Student> javaStudents,
                                                         List<Student> sqlStudents,
                                                         List<Student> sqlStudentsPartTime,
                                                         List<Student> javaStudentsPartTime,
                                                         List<Student> newStudents,
                                                         List<Assignment> newAssignments) {
        System.out.println("Please enter a date(dd-MM-yyyy):");
        boolean flag;
        do {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
                Scanner input5 = new Scanner(System.in);
                String line = input5.next();
                LocalDate checkDate = LocalDate.parse(line, formatter);
                int weekNumber = checkDate.get(WeekFields.ISO.weekOfYear());
                List<Student> assignmentsPerJavaStudent = new ArrayList<>();

                for (Assignment assignments : javaAssignments) {
                    int assignmentWeekNumber = assignments.getSubDateTime().get(WeekFields.ISO.weekOfYear());
                    if (weekNumber == assignmentWeekNumber) {
                        assignmentsPerJavaStudent.addAll(javaStudents);
                        System.out.println("The assignment " + assignments.getTitle() +
                                " must be submitted before " + assignments.getSubDateTime() + " by the students " +
                                assignmentsPerJavaStudent);
                    }

                }

                List<Student> assignmentsPerSqlStudent = new ArrayList<>();

                for (Assignment assignments : sqlAssignments) {
                    int assignmentWeekNumber = assignments.getSubDateTime().get(WeekFields.ISO.weekOfYear());
                    if (weekNumber == assignmentWeekNumber) {
                        assignmentsPerSqlStudent.addAll(sqlStudents);
                        System.out.println("The assignment " + assignments.getTitle() +
                                " must be submitted before " + assignments.getSubDateTime() + " by the students " +
                                assignmentsPerSqlStudent);
                    }

                }
                List<Student> assignmentsPerSqlStudentPartTime = new ArrayList<>();

                for (Assignment assignments : sqlAssignments) {
                    int assignmentWeekNumber = assignments.getSubDateTime().get(WeekFields.ISO.weekOfYear());
                    if (weekNumber == assignmentWeekNumber) {
                        assignmentsPerSqlStudentPartTime.addAll(sqlStudentsPartTime);
                        System.out.println("The assignment " + assignments.getTitle() +
                                " must be submitted before " + assignments.getSubDateTime() + " by the students " +
                                assignmentsPerSqlStudentPartTime);
                    }

                }
                List<Student> assignmentsPerJavaStudentPartTime = new ArrayList<>();
                for (Assignment assignments : javaAssignments) {
                    int assignmentWeekNumber = assignments.getSubDateTime().get(WeekFields.ISO.weekOfYear());
                    if (weekNumber == assignmentWeekNumber) {
                        assignmentsPerJavaStudentPartTime.addAll(javaStudentsPartTime);
                        System.out.println("The assignment " + assignments.getTitle() +
                                " must be submitted before " + assignments.getSubDateTime() + " by the students " +
                                assignmentsPerJavaStudentPartTime);

                    }
                }
                createAssignmentsPerNewStudentsList(newStudents, newAssignments, weekNumber);

                flag = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one (dd-MM-yyyy)");
                flag = true;
            }
        } while (flag);
    }

    private static void createAssignmentsPerNewStudentsList(List<Student> newStudents,
                                                            List<Assignment> newAssignments, int weekNumber) {
        List<Student> assignmentsPerNewstudents = new ArrayList<>();
        if (!newStudents.isEmpty()) {
            for (Assignment assignments : newAssignments) {
                int assignmentWeekNumber = assignments.getSubDateTime().get(WeekFields.ISO.weekOfYear());
                if (weekNumber == assignmentWeekNumber) {
                    assignmentsPerNewstudents.addAll(newStudents);
                    System.out.println("The assignment " + assignments.getTitle() +
                            " must be submitted before " + assignments.getSubDateTime() + " by the students " +
                            assignmentsPerNewstudents);
                }
            }
        }
    }
}
