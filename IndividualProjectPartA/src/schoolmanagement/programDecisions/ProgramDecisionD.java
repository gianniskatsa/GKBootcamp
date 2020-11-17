package schoolmanagement.programDecisions;

import schoolmanagement.beans.Assignment;

import java.util.List;
import java.util.Scanner;

import static schoolmanagement.SchoolManagementMain.count;
import static schoolmanagement.SchoolManagementMain.setCount;

public class ProgramDecisionD {
    public static void programDecisionD(List<Assignment> javaAssignments,
                                        List<Assignment> sqlAssignments, Scanner input) {
        setCount();
        System.out.println("Choose between 'Java', 'SQL'");
        String tmp = input.next();
        for (int k = 0; k < count; k++) {
            Assignment assignment = new Assignment("null", "null", "11-11-1111", 100, 100);
            if (tmp.contains("Java")) {
                javaAssignments.add(addAssignmentsToJava(javaAssignments, input, assignment));
            } else {
                sqlAssignments.add(addAssignmentsToSql(sqlAssignments, input, assignment));
            }
        }
    }

    private static Assignment addAssignmentsToSql(List<Assignment> sqlAssignments,
                                                  Scanner input, Assignment assignment) {
        addAssignmentDetails(input, assignment, "Enter Assignment's submission date time (dd-MM-yyyy)");
        sqlAssignments.add(assignment);
        return assignment;
    }

    private static Assignment addAssignmentsToJava(List<Assignment> javaAssignments,
                                                   Scanner input, Assignment assignment) {
        addAssignmentDetails(input, assignment, "Enter Assignment's submission date time (dd-MM-yyyy)");
        return assignment;
    }

    private static void addAssignmentDetails(Scanner input, Assignment assignment, String s) {
        System.out.println("Enter assignment's title");
        assignment.setTitle(input.next());
        System.out.println(s);
        assignment.setSubDateTime();
        System.out.println("Enter Assignment's oral mark");
        assignment.setOralMark();
        System.out.println("Enter Assignment's total mark");
        assignment.setTotalMark();
    }
}
