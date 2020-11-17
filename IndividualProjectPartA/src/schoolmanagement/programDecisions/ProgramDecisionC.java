package schoolmanagement.programDecisions;

import schoolmanagement.beans.Trainer;

import java.util.List;
import java.util.Scanner;

import static schoolmanagement.SchoolManagementMain.count;
import static schoolmanagement.SchoolManagementMain.setCount;

public class ProgramDecisionC {
    public static void programDecisionC(List<Trainer> sqlTrainers, List<Trainer> javaTrainers, Scanner input) {
        setCount();
        System.out.println("Choose between the available courses 'Java' or 'SQL' ");
        String tmp = input.next();
        for (int k = 0; k < count; k++) {
            Trainer trainer = new Trainer();
            if (tmp.contains("Java")) {
                javaTrainers.add(addJavaTrainers(input, trainer));
            } else {
                sqlTrainers.add(addSqlTrainer(input, trainer));
            }
        }
    }

    private static Trainer addJavaTrainers(Scanner input, Trainer trainer) {
        addDetailsToTrainer(input, trainer);

        return trainer;
    }

    private static Trainer addSqlTrainer(Scanner input, Trainer trainer) {
        addDetailsToTrainer(input, trainer);
        return trainer;
    }

    private static void addDetailsToTrainer(Scanner input, Trainer trainer) {
        System.out.println("Enter trainer's first name");
        trainer.setFirstName(input.next());
        System.out.println("Enter trainer's last name");
        trainer.setLastName(input.next());
    }
}
