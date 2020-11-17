package schoolmanagement.utils;

import schoolmanagement.beans.Assignment;
import schoolmanagement.beans.Course;
import schoolmanagement.beans.Student;
import schoolmanagement.beans.Trainer;

import java.util.List;

public class StaticUtils {
    public static void addCoursesToFirstList(List<Trainer> sqlTrainers, List<Trainer> javaTrainers, List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> javaStudents, List<Student> javaStudentsPartTime, List<Student> sqlStudentsPartTime, List<Student> sqlStudents, List<Course> courses) {
        courses.add(new Course("CB12", "SQL", "Full time", "22-05-2020", "20-12-2021", sqlTrainers, sqlStudents, sqlAssignments));
        courses.add(new Course("CB12", "Java", "Full time", "20-11-2020", "20-12-2021", javaTrainers, javaStudents, javaAssignments));
        courses.add(new Course("CB12", "Java", "Part Time", "22-05-2020", "22-10-2020", javaTrainers, javaStudentsPartTime, javaAssignments));
        courses.add(new Course("CB12", "SQL", "Part Time", "22-05-2020", "22-10-2020", sqlTrainers, sqlStudentsPartTime, sqlAssignments));
    }


    public static void addSqlStudentsToList(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> sqlStudents) {
        sqlStudents.add(new Student("Antonis", "Antonioy", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Vasilis", "Vasileiou", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Kostas", "Kosta", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Apostolis", "Apostolidis", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Alex", "Alexiou", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Lampros", "Lamprou", "02-05-1931", 2500, sqlAssignments));
        sqlStudents.add(new Student("Makis", "Maki", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Giorgos", "Georgiou", "22-05-1991", 2500, sqlAssignments));

    }

    public static void addSqlStudentsPartTimeToList(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> sqlStudentsPartTime) {
        sqlStudentsPartTime.add(new Student("Vailis", "Karas", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Nick", "Kaein", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Nasos", "Lorpis", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Ben", "Bakalis", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Asteris", "ASteriou", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Keith", "Cole", "02-05-1931", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Dino", "Pean", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Kino", "Joker", "22-05-1991", 2500, sqlAssignments));
        sqlStudentsPartTime.add(new Student("Ken", "Babe", "22-05-1991", 2500, sqlAssignments));

    }

   public static void addJavaStudentToList(List<Assignment> javaAssignments, List<Student> javaStudents) {
        javaStudents.add(new Student("Giannis", "Katsa", "12-01-1981", 2500, javaAssignments));
        javaStudents.add(new Student("Adreas", "Adreou", "22-05-1921", 2500, javaAssignments));
        javaStudents.add(new Student("Lampros", "Lamprou", "02-05-1931", 2500, javaAssignments));
        javaStudents.add(new Student("Makis", "Maki", "22-05-1991", 2500, javaAssignments));
        javaStudents.add(new Student("Giorgos", "Georgiou", "22-05-1991", 2500, javaAssignments));
        javaStudents.add(new Student("Kino", "Joker", "22-05-1991", 2500, javaAssignments));

    }

    public static void addJavaStudentPartTimeToList(List<Assignment> javaAssignments, List<Student> javaStudentsPartTime) {
        javaStudentsPartTime.add(new Student("Mixos", "Prinos", "12-01-1981", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Kostis", "Gianoy", "22-05-1921", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Asteris", "Mpampi", "02-05-1931", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Ken", "Babe", "22-05-1991", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Poli", "Jina", "22-05-1991", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Makis", "Maki", "22-05-1991", 2500, javaAssignments));

    }

    public static void addSqlAssignmentsToList(List<Assignment> sqlAssignments) {
        sqlAssignments.add(new Assignment("Infrastructure", "Create a private School infrastructure", "18-11-2020", 100, 100));
        sqlAssignments.add(new Assignment("Terminal", "Create a hospital terminal", "12-12-2020", 100, 100));
        sqlAssignments.add(new Assignment("Elements", "Create a list of elements", "10-09-2021", 100, 100));
        sqlAssignments.add(new Assignment("React", "Create a website", "15-08-2021", 100, 100));
        sqlAssignments.add(new Assignment("DynamoDB", "Create a database", "20-07-2021", 100, 100));
    }

    public static void addAssignmentsToList(List<Assignment> javaAssignments) {
        javaAssignments.add(new Assignment("School", "Create a private School infrastructure", "18-10-2020", 100, 100));
        javaAssignments.add(new Assignment("Hospital", "Create a hospital terminal", "20-12-2020", 100, 100));
        javaAssignments.add(new Assignment("Elements", "Create a list of elements", "10-05-2021", 100, 100));
        javaAssignments.add(new Assignment("Website", "Create a website", "15-04-2021", 100, 100));
        javaAssignments.add(new Assignment("Database", "Create a database", "20-06-2021", 100, 100));
    }

    public static void addJavaTrainersToList(List<Trainer> javaTrainers) {
        javaTrainers.add(new Trainer("Vladimiros", "Fotiadis", "Java"));
        javaTrainers.add(new Trainer("Andreas", "Hliadis", "Python"));
    }

    public static void addTrainersToList(List<Trainer> sqlTrainers) {
        sqlTrainers.add(new Trainer("Nick", "Kalathis", "SQL"));
        sqlTrainers.add(new Trainer("Giorgos", "Paspalakis", "C#"));
    }
}
