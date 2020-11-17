package schoolmanagement.programDecisions;

import schoolmanagement.beans.Assignment;
import schoolmanagement.beans.Course;
import schoolmanagement.beans.Student;
import schoolmanagement.beans.Trainer;

import java.util.List;
import java.util.Scanner;

import static schoolmanagement.SchoolManagementMain.count;
import static schoolmanagement.SchoolManagementMain.setCount;

public class ProgramDecisionA {

    public static void programDecisionA(List<Course> courses,
                                        List<Trainer> newTrainers,
                                        List<Student> newStudents,
                                        List<Assignment> newAssignments,
                                        Scanner input) {

        Scanner inputCourses = new Scanner(System.in);
        setCount();

        for (int i = 0; i < count; i++) {
            Course course = new Course("null", "null", "null", "11-11-1111", "11-11-1111", newTrainers, newStudents, newAssignments);
            addCourseDetails(inputCourses, i, course);
            System.out.println("Do you wish to add trainers to this course (Y/N)?");
            setNewTrainers(newTrainers, input, new Scanner(System.in));
            System.out.println("Do you wish to add new students to this course (Y/N)?");
            setNewStudents(newStudents, newAssignments, input, new Scanner(System.in));
            System.out.println("Do you wish to add new assignments to this course (Y/N)?");
            setNewAssignments(newAssignments, input, new Scanner(System.in));
            courses.add(course);
        }
    }

    private static void setNewAssignments(List<Assignment> newAssignments, Scanner input, Scanner input4) {
        if (input4.hasNext("Y")) {
            System.out.println("How many do you wish to add?");
            setCount();
            for (int k = 0; k < count; k++) {
                Assignment assignment = new Assignment();
                addAssignmentsDetails(input, assignment);
                newAssignments.add(assignment);
            }
        }
    }

    private static void setNewStudents(List<Student> newStudents,
                                       List<Assignment> newAssignments,
                                       Scanner input, Scanner input3) {
        if (input3.hasNext("Y")) {
            System.out.println("How many do you wish to add?");
            setCount();
            for (int k = 0; k < count; k++) {
                Student student = addStudentDetails(newAssignments, input);
                newStudents.add(student);
            }
        }
    }

    private static void setNewTrainers(List<Trainer> newTrainers, Scanner input, Scanner input2) {
        if (input2.hasNext("Y")) {
            System.out.println("How many do you wish to add?");
            setCount();
            for (int j = 0; j < count; j++) {
                Trainer trainer = addTrainersDetails(input);
                newTrainers.add(trainer);
            }
        }
    }

    private static void addAssignmentsDetails(Scanner input, Assignment assignment) {
        System.out.println("Enter assignment's title");
        assignment.setTitle(input.next());
        System.out.println("Enter assignment's description");
        assignment.setDescription(input.next());
        System.out.println("Enter Assignment's submission date time (dd-MM-yyyy)");
        assignment.setSubDateTime();
        System.out.println("Enter Assignment's oral mark");
        assignment.setOralMark();
        System.out.println("Enter Assignment's total mark");
        assignment.setTotalMark();
    }

    private static Student addStudentDetails(List<Assignment> newAssignments, Scanner input) {
        Student student = new Student("null", "null", "22-01-0101", 2500, newAssignments);
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of Birth (dd-MM-yyyy)");
        student.setDateOfBirth();
        return student;
    }

    private static Trainer addTrainersDetails(Scanner input) {
        Trainer trainer = new Trainer();
        System.out.println("Enter trainer's first name");
        trainer.setFirstName(input.next());
        System.out.println("Enter trainer's last name");
        trainer.setLastName(input.next());
        return trainer;
    }

    private static void addCourseDetails(Scanner input1, int i, Course course) {

        System.out.println("Enter details for course: " + (i + 1));
        System.out.println("Enter Course Title: ");
        course.setCourseTitle(input1.next());
        System.out.println("Enter Course stream: ");
        course.setStream(input1.next());
        System.out.println("Enter Course type");
        course.setType(input1.next());
        System.out.println("Enter Course Start Date (dd-MM-yyyy)");
        course.setStartDate();
        System.out.println("Enter Course End Date (dd-MM-yyyy)");
        course.setEndDate();
    }
}


