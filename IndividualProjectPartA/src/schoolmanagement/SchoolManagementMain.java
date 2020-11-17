package schoolmanagement;

import schoolmanagement.beans.Assignment;
import schoolmanagement.beans.Course;
import schoolmanagement.beans.Student;
import schoolmanagement.beans.Trainer;

import java.util.*;
import java.lang.*;

import static schoolmanagement.utils.PrintUtils.*;
import static schoolmanagement.utils.StaticUtils.*;
import static schoolmanagement.programDecisions.ProgramDecisionA.programDecisionA;
import static schoolmanagement.programDecisions.ProgramDecisionB.programDecisionB;
import static schoolmanagement.programDecisions.ProgramDecisionC.programDecisionC;
import static schoolmanagement.programDecisions.ProgramDecisionD.programDecisionD;

public class SchoolManagementMain {
    public static int count;

    public static void main(String[] args) {

        List<Trainer> sqlTrainers = new ArrayList<>();
        addTrainersToList(sqlTrainers);

        List<Trainer> javaTrainers = new ArrayList<>();
        addJavaTrainersToList(javaTrainers);

        List<Assignment> javaAssignments = new ArrayList<>();
        addAssignmentsToList(javaAssignments);

        List<Assignment> sqlAssignments = new ArrayList<>();
        addSqlAssignmentsToList(sqlAssignments);

        List<Student> javaStudents = new ArrayList<>();
        addJavaStudentToList(javaAssignments, javaStudents);

        List<Student> sqlStudents = new ArrayList<>();
        addSqlStudentsToList(javaAssignments, sqlAssignments, sqlStudents);

        List<Student> sqlStudentsPartTime = new ArrayList<>();
        addSqlStudentsPartTimeToList(sqlAssignments, javaAssignments, sqlStudentsPartTime);

        List<Student> javaStudentsPartTime = new ArrayList<>();
        addJavaStudentPartTimeToList(javaAssignments, javaStudentsPartTime);

        List<Course> courses = new ArrayList<>();
        addCoursesToFirstList(sqlTrainers, javaTrainers, javaAssignments, sqlAssignments, javaStudents,
                javaStudentsPartTime, sqlStudents, sqlStudentsPartTime, courses);

        startThePrints();

        List<Trainer> newTrainers = new ArrayList<>();
        List<Student> newStudents = new ArrayList<>();
        List<Assignment> newAssignments = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String firstDecision = input.next();

        if (firstDecision.contains("A")) {
            System.out.println("How many courses do you want to add?");
            programDecisionA(courses, newTrainers, newStudents, newAssignments, input);
        } else if (firstDecision.contains("B")) {
            System.out.println("How many students do you wish to add?");
            programDecisionB(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, javaAssignments, sqlAssignments, input);
        } else if (firstDecision.contains("C")) {
            System.out.println("How many trainers do you wish to add?");
            programDecisionC(sqlTrainers, javaTrainers, input);
        } else if (firstDecision.contains("D")) {
            System.out.println("How many Assignments do you wish to add?");
            programDecisionD(javaAssignments, sqlAssignments, input);
        }

        startTheSecondPrints();
        String secondDecision = input.next();
        if (secondDecision.contains("A")) {
            printOptionCourses(courses);
        } else if (secondDecision.contains("B")) {
            printOptionTrainers(javaTrainers, newTrainers, sqlTrainers);
        } else if (secondDecision.contains("C")) {
            printOptionTrainersPerCourse(courses, javaTrainers, sqlTrainers, newTrainers);
        } else if (secondDecision.contains("D")) {
            printOptionStudentsAll(courses);
        } else if (secondDecision.contains("E")) {
            printOptionStudentsPerCourse(courses);
        } else if (secondDecision.contains("F")) {
            printOptionAssignmentsAll(javaAssignments, sqlAssignments, newAssignments);
        } else if (secondDecision.contains("G")) {
            printOptionAssignmentsPerCourse(courses);
        } else if (secondDecision.contains("H")) {
            printOptionAssignmentPerStudent(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, newStudents);
        } else if (secondDecision.contains("I")) {
            printOptionDuplicateStudents(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime);
        } else if (secondDecision.contains("J")) {
            printOptionCheckDateForAssignment(javaAssignments, sqlAssignments, javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, newStudents, newAssignments);
        }
    }

    public static void setCount() {
        boolean flag1;
        do {
            try {
                Scanner input = new Scanner(System.in);
                count = input.nextInt();
                flag1 = false;
            } catch (Exception e) {
                System.err.println("This is not a valid number. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        } while (flag1);
    }
}






