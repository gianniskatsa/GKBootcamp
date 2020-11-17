package schoolmanagement.programDecisions;

import schoolmanagement.beans.Assignment;
import schoolmanagement.beans.Student;

import java.util.List;
import java.util.Scanner;

import static schoolmanagement.SchoolManagementMain.count;
import static schoolmanagement.SchoolManagementMain.setCount;

public class ProgramDecisionB {

    public static void programDecisionB(List<Student> javaStudents,
                                        List<Student> sqlStudents,
                                        List<Student> sqlStudentsPartTime,
                                        List<Student> javaStudentsPartTime,
                                        List<Assignment> javaAssignmentList,
                                        List<Assignment> sqlAssignmentList,
                                        Scanner input) {
        setCount();
        System.out.println("Choose between the available courses A) Java Full Time," +
                "B) SQL Full Time, C) Sql Part time,D) Java Part time");
        String tmp = input.next();

        for (int k = 0; k < count; k++) {
            if (tmp.contains("A")) {
                javaStudents.add(addStudents(input, javaAssignmentList));
            } else if (tmp.contains("B")) {
                sqlStudents.add(addStudents(input, sqlAssignmentList));
            } else if (tmp.contains("C")) {
                sqlStudentsPartTime.add(addStudents(input, sqlAssignmentList));
            } else {
                javaStudentsPartTime.add(addStudents(input, javaAssignmentList));
            }
        }
    }

    private static Student addStudents(Scanner input, List<Assignment> assignmentList) {
        Student student = new Student();
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of birth (dd-MM-yyyy)");
        student.setDateOfBirth();
        student.setAssignments(assignmentList);
        return student;
    }
}
