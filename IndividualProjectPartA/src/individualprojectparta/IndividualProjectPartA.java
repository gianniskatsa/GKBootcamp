package individualprojectparta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;
import java.lang.*;

public class IndividualProjectPartA {
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static int count;


    public static void main(String[] args) {
//                 **Here we add the hardcoded stuff **this implementation of the project uses Lists without creating extra classes**

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


//                             **Hardcoded ENDS HERE**
//            **The part of the program that enters new entries to the fields begins here**
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
            programDecisionB(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, input);
        } else if (firstDecision.contains("C")) {
            System.out.println("How many trainers do you wish to add?");
            programDecisionC(sqlTrainers, javaTrainers, input);
        } else if (firstDecision.contains("D")) {
            System.out.println("How many Assignments do you wish to add?");
            programDecisionD(javaAssignments, sqlAssignments, input);
        }
        // **The part of the program that Prints the outcome begins here**

        do {
            startTheSecondPrints();
            String secondDecision = input.next();
            if (secondDecision.contains("A")) {
                printOptionCourses(courses);
            } else if (secondDecision.contains("B")) {
                printOptionTrainers(courses);
            } else if (secondDecision.contains("C")) {
                printOptionTrainersPerCourse(courses);
            } else if (secondDecision.contains("D")) {
                printOptionStudentsAll(courses);
            } else if (secondDecision.contains("E")) {
                printOptionStudentsPercourse(courses);
            } else if (secondDecision.contains("F")) {
                printOptionAssignmentsAll(courses);
            } else if (secondDecision.contains("G")) {
                printOptionAssignmentsPerCourse(courses);
            } else if (secondDecision.contains("H")) {
                printOptionAssignmentPerStudent(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, newStudents);
            } else if (secondDecision.contains("I")) {
                printOptionDuplicateStudents(javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime);
            } else if (secondDecision.contains("J")) {
                printOptionCheckDateForAssignment(javaAssignments, sqlAssignments, javaStudents, sqlStudents, sqlStudentsPartTime, javaStudentsPartTime, newStudents, newAssignments);
            }
        } while (true);
    }

    //**Main Ends Here**


    private static void printOptionCheckDateForAssignment(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> javaStudents, List<Student> sqlStudents, List<Student> sqlStudentsPartTime, List<Student> javaStudentsPartTime, List<Student> newStudents, List<Assignment> newAssignments) {
        System.out.println("Please enter a date:");
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
                List<Student> assignmentsPerNewstudents = new ArrayList<>();
                if (newStudents.isEmpty()) {

                } else {
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


                flag = false;
            } catch (Exception e) {
                System.err.println("Invalid date value. ");
                System.out.println("Please enter a new one (dd-MM-yyyy)");
                flag = true;
            }
        } while (flag);
    }

    private static void printOptionDuplicateStudents(List<Student> javaStudents, List<Student> sqlStudents, List<Student> sqlStudentsPartTime, List<Student> javaStudentsPartTime) {
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

    private static void printOptionAssignmentPerStudent(List<Student> javaStudents, List<Student> sqlStudents, List<Student> sqlStudentsPartTime, List<Student> javaStudentsPartTime, List<Student> newStudents) {
        for (Student student : javaStudents) {
            System.out.println("The student's name is " + student.getFirstName() + " "
                    + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignmentsFromStudents());
        }
        for (Student student : javaStudentsPartTime) {
            System.out.println("The student's name is " + student.getFirstName() + " "
                    + student.getLastName() + " and these are the assignments he has to submit "
                    + student.getAssignmentsFromStudents());
        }
        for (Student student : sqlStudents) {
            System.out.println("The student's name is " + student.getFirstName() +
                    " " + student.getLastName() + " and these are the assignments he has to submit " + student.getAssignmentsFromStudents());
        }
        for (Student student : sqlStudentsPartTime) {
            System.out.println("The student's name is " + student.getFirstName() +
                    " " + student.getLastName() + " and these are the assignments he has to submit " + student.getAssignmentsFromStudents());
        }
        if (newStudents.isEmpty()) {

        } else {
            for (Student student : newStudents) {
                System.out.println("The student's name is " + student.getFirstName() +
                        " " + student.getLastName() + " and these are the assignments he has to submit " + student.getAssignmentsFromStudents());

            }

        }
    }

    private static void printOptionAssignmentsPerCourse(List<Course> courses) {
        for (Course course : courses) {

            System.out.println("The course " + course.getStream() + " " + course.getType() + " has the next assignments " + course.getAssignments());
        }
    }

    private static void printOptionAssignmentsAll(List<Course> courses) {

        for (Course course : courses) {
            System.out.println("Our courses have the next assignments " + course.getAssignments());
        }
    }

    private static void printOptionStudentsPercourse(List<Course> courses) {
        for (Course course : courses) {
            System.out.println("The course " + course.getStream() + " with the type " + course.getType() + " has the next students " + course.getStudents());
        }
    }

    private static void printOptionStudentsAll(List<Course> courses) {
        System.out.println("The Students studying at our school are");
        for (Course course : courses) {
            System.out.println(course.getStudents());
        }
    }

    private static void printOptionTrainersPerCourse(List<Course> courses) {
        System.out.println("Print all the trainers per course :");
        for (Course course : courses) {
            System.out.println("The trainers for the course "
                    + course.getStream() + " " + course.getType() + " are " + course.getTrainers());

        }
    }

    private static void printOptionTrainers(List<Course> courses) {
        System.out.println("The trainers available are:\n");
        for (Course course : courses) {
            System.out.println("The trainers of the school are  " + course.getTrainers());

        }
    }

    private static void printOptionCourses(List<Course> courses) {
        System.out.println("The courses available are:\n");
        for (Course course : courses) {
            System.out.println(course.getStream() + " " + course.getType() + " starts at " + course.getStart_date() + " and ends at " + course.getEndDate());
        }
    }

    private static void startTheSecondPrints() {
        System.out.println("Choose between the next options: " + "\n" + "A) Print all the available courses"
                + "\n" + "B) Print all the available trainers" + "\n" + "C) Print the trainers per course" + "\n" +
                "D) Print all the students" + "\n" + "E) Print all the students per course" + "\n" +
                "F) Print all the assignments " + "\n" + "G) Print all the assignments per course" + "\n" +
                "H) Print all the assignments per students" + "\n" +
                "I) Print a list of students that belong to more than one Courses" + "\n" +
                "J) Submit a date to check if a student has an assignment to submit on that date" + "\n");
    }

    private static void startThePrints() {
        System.out.println("Welcome to our Private School's Command Prompt application" + "\n");
        System.out.println("Choose between the next options: " + "\n" + "A) Enter more courses" + "\n" +
                "B) Enter more students" + "\n" + "C) Enter more trainers" + "\n" +
                "D) Enter more assignments" + "\n" + "E) Do not enter input");
    }

    private static void programDecisionD(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, Scanner input) {

        boolean flag1;
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                int countAssignments = input1.nextInt();
                System.out.println("Choose between 'Java', 'SQL'");
                if (input.next().contains("Java")) {
                    for (int k = 0; k < countAssignments; k++) {
                        Assignment assignment = new Assignment();
                        addAssignmentsToJava(javaAssignments, input, assignment);

                    }
                } else {
                    for (int k = 0; k < countAssignments; k++) {
                        Assignment assignment = new Assignment();
                        addAssignmentsToSql(sqlAssignments, input, assignment);

                    }
                }
                flag1 = false;
            } catch (Exception e) {
                System.err.println("This is not a valid number. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        } while (flag1);

    }

    private static void programDecisionC(List<Trainer> sqlTrainers, List<Trainer> javaTrainers, Scanner input) {

        boolean flag1;
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                int countTrainers = input1.nextInt();
                System.out.println("Choose between the available courses 'Java' or 'SQL' ");
                if (input.next().contains("Java")) {
                    for (int k = 0; k < countTrainers; k++) {
                        Trainer trainer = new Trainer();
                        addJavaTrainers(javaTrainers, input, trainer);
                    }

                } else {
                    for (int k = 0; k < countTrainers; k++) {
                        Trainer trainer = new Trainer();
                        addSqltrainer(sqlTrainers, input, trainer);
                    }
                }
                flag1 = false;
            } catch (Exception e) {
                System.err.println("This is not a valid number. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        } while (flag1);

    }

    private static void programDecisionB(List<Student> javaStudents, List<Student> sqlStudents, List<Student> sqlStudentsPartTime, List<Student> javaStudentsPartTime, Scanner input) {

        boolean flag1;
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                int countStudents = input1.nextInt();
                System.out.println("Choose between the available courses A)Java Full Time,B) SQL Full Time, C) Sql Part time,D) Java Part time");
                String tmp = input1.next();
                if (tmp.contains("A")) {
                    for (int k = 0; k < countStudents; k++) {
                        Student student = new Student();
                        
                        addJavaStudents(javaStudents, input, student);
//                    addAssignmentToStudentJava(javaAssignments, input);
                    }
                    flag1 = false;
                } else if (tmp.contains("B")) {
                    for (int k = 0; k < countStudents; k++) {
                        Student student = new Student();
                        addSqlStudents(sqlStudents, input, student);
//                    addAssignmentToStudentSql(sqlAssignments, input);
                    }
                } else if (tmp.contains("C")) {
                    for (int k = 0; k < countStudents; k++) {
                        Student student = new Student();
                        addSqlStudentsPartTime(sqlStudentsPartTime, input, student);
//                    addAssignmentToStudentSqlPartTime(sqlAssignments, input);
                    }
                    flag1 = false;
                } else {
                    for (int k = 0; k < countStudents; k++) {
                        Student student = new Student();
                        addJavaStudentsPartTime(javaStudentsPartTime, input, student);
//                    addAssignmentToStudentSqlPartTime(javaAssignments, input);
                    }
                    flag1 = false;
                }

                flag1 = false;
            } catch (Exception e) {
                System.err.println("This is not a valid number. ");
                System.out.println("Please enter a new one: ");
                flag1 = true;
            }
        } while (flag1);

    }

    private static void programDecisionA(List<Course> courses, List<Trainer> newTrainers, List<Student> newStudents, List<Assignment> newAssignments, Scanner input) {


        Scanner input1 = new Scanner(System.in);
        getCount();
        for (int i = 0; i < count; i++) {
            Scanner input2 = new Scanner(System.in);
            Course course = new Course("null", "null", "null", "11-11-1111", "11-11-1111", newTrainers, newStudents, newAssignments);
            addIfFirstDecisionCourseDetails(input1, i, course);
            System.out.println("Do you wish to add trainers to this course?");
            if (input2.hasNext("Y")) {
                System.out.println("How many do you wish to add?");
                getCount();
                for (int j = 0; j < count; j++) {
                    Trainer trainer = addIfFirstDecisionTrainersDetails(input);
                    newTrainers.add(trainer);
                }
            }
            System.out.println("Do you wish to add new students to this course?");
            Scanner input3 = new Scanner(System.in);
            if (input3.hasNext("Y")) {
                System.out.println("How many do you wish to add?");
                getCount();
                for (int k = 0; k < count; k++) {
                    Student student = addIfFirstDecisionStudentDetails(newAssignments, input);
                    newStudents.add(student);
                }
            }
            System.out.println("Do you wish to add new assignments to this course?");
            Scanner input4 = new Scanner(System.in);
            if (input4.hasNext("Y")) {
                System.out.println("How many do you wish to add?");
                getCount();
                for (int k = 0; k < count; k++) {
                    Assignment assignment = new Assignment();
                    System.out.println("Enter assignment's title");
                    assignment.setTitle(input.next());
                    System.out.println("Enter assignment's description");
                    assignment.setDescription(input.next());
                    System.out.println("Enter Assignment's submission date time");
                    assignment.setSubDateTime();
                    System.out.println("Enter Assignment's oral mark");
                    assignment.setOralMark();
                    System.out.println("Enter Assignment's total mark");
                    assignment.setTotalMark();
                    newAssignments.add(assignment);
                }
            }
            courses.add(course);
        }

    }

    private static int getCount() {
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
        return count;
    }


    private static Assignment addIfFirstDecisionAssignmentsDetails(Scanner input) {
        Assignment assignment = new Assignment();
        System.out.println("Enter assignment's title");
        assignment.setTitle(input.next());
        System.out.println("Enter assignment's description");
        assignment.setDescription(input.next());
        System.out.println("Enter Assignment's submission date time");
        assignment.setSubDateTime();
        System.out.println("Enter Assignment's oral mark");
        assignment.setOralMark();
        System.out.println("Enter Assignment's total mark");
        assignment.setTotalMark();
        return assignment;
    }


    private static Student addIfFirstDecisionStudentDetails(List<Assignment> newAssignments, Scanner input) {
        Student student = new Student("null", "null", "22-01-0101", 2500, newAssignments);
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of Birth");
        student.setDateOfBirth();
        return student;
    }


    private static Trainer addIfFirstDecisionTrainersDetails(Scanner input) {
        Trainer trainer = new Trainer();
        System.out.println("Enter trainer's first name");
        trainer.setFirstName(input.next());
        System.out.println("Enter trainer's last name");
        trainer.setLastName(input.next());
        return trainer;
    }

    private static void addIfFirstDecisionCourseDetails(Scanner input1, int i, Course course) {


        System.out.println("Enter details for course: " + (i + 1));
        System.out.println("Enter Course Title: ");
        course.setCourseTitle(input1.next());
        System.out.println("Enter Course stream: ");
        course.setStream(input1.next());
        System.out.println("Enter Course type");
        course.setType(input1.next());
        System.out.println("Enter Course Start Date");
        course.setStartDate();
        System.out.println("Enter Course End Date");
        course.setEndDate();

    }


    private static void addCoursesToFirstList(List<Trainer> sqlTrainers, List<Trainer> javaTrainers, List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> javaStudents, List<Student> javaStudentsPartTime, List<Student> sqlStudentsPartTime, List<Student> sqlStudents, List<Course> courses) {
        courses.add(new Course("CB12", "SQL", "Full time", "22-05-2020", "20-12-2021", sqlTrainers, sqlStudents, sqlAssignments));
        courses.add(new Course("CB12", "Java", "Full time", "20-11-2020", "20-12-2021", javaTrainers, javaStudents, javaAssignments));
        courses.add(new Course("CB12", "Java", "Part Time", "22-05-2020", "22-10-2020", javaTrainers, javaStudentsPartTime, javaAssignments));
        courses.add(new Course("CB12", "SQL", "Part Time", "22-05-2020", "22-10-2020", sqlTrainers, sqlStudentsPartTime, sqlAssignments));
    }

    private static void addSqltrainer(List<Trainer> sqlTrainers, Scanner input, Trainer trainer) {
        System.out.println("Enter trainer's first name");
        trainer.setFirstName(input.next());
        System.out.println("Enter trainer's last name");
        trainer.setLastName(input.next());
        sqlTrainers.add(trainer);
    }


    private static void addJavaTrainers(List<Trainer> javaTrainers, Scanner input, Trainer trainer) {
        System.out.println("Enter trainer's first name");
        trainer.setFirstName(input.next());
        System.out.println("Enter trainer's last name");
        trainer.setLastName(input.next());
        javaTrainers.add(trainer);
    }

    private static void addAssignmentToStudentSql(List<Assignment> sqlAssignments, Scanner input) {
        System.out.println("Do you wish to add assignments to the student");
        Scanner input4 = new Scanner(System.in);
        if (input4.next().contains("Y")) {
            System.out.println("How many do you wish to add?");
            int countAssignments = input.nextInt();
            for (int l = 0; l < countAssignments; l++) {
                Assignment assignment = new Assignment();
                System.out.println("Enter assignment's title");
                assignment.setTitle(input.next());
                System.out.println("Enter Assignment's submission date time");
                assignment.setSubDateTime();
                System.out.println("Enter Assignment's oral mark");
                assignment.setOralMark();
                System.out.println("Enter Assignment's total mark");
                assignment.setTotalMark();
                sqlAssignments.add(assignment);
            }
        }
    }

    private static void addAssignmentToStudentSqlPartTime(List<Assignment> sqlAssignments, Scanner input) {
        System.out.println("Do you wish to add assignments to the student");
        Scanner input4 = new Scanner(System.in);
        if (input4.next().contains("Y")) {
            System.out.println("How many do you wish to add?");
            int countAssignments = input.nextInt();
            for (int l = 0; l < countAssignments; l++) {
                Assignment assignment = new Assignment();
                System.out.println("Enter assignment's title");
                assignment.setTitle(input.next());
                System.out.println("Enter Assignment's submission date time");
                assignment.setSubDateTime();
                System.out.println("Enter Assignment's oral mark");
                assignment.setOralMark();
                System.out.println("Enter Assignment's total mark");
                assignment.setTotalMark();
                sqlAssignments.add(assignment);
            }
        }
    }


    private static void addAssignmentToStudentJava(List<Assignment> javaAssignments, Scanner input) {
        System.out.println("Do you wish to add assignments to the student");
        Scanner input4 = new Scanner(System.in);
        if (input4.next().contains("Y")) {
            System.out.println("How many do you wish to add?");
            int countAssignments = input.nextInt();
            for (int l = 0; l < countAssignments; l++) {
                Assignment assignment = new Assignment();
                System.out.println("Enter assignment's title");
                assignment.setTitle(input.next());
                System.out.println("Enter Assignment's submission date time");
                assignment.setSubDateTime();
                System.out.println("Enter Assignment's oral mark");
                assignment.setOralMark();
                System.out.println("Enter Assignment's total mark");
                assignment.setTotalMark();
                javaAssignments.add(assignment);
            }
        }
    }

    private static void addJavaStudents(List<Student> javaStudents, Scanner input, Student student) {
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of birth");
        student.setDateOfBirth();
        javaStudents.add(student);

    }

    private static void addSqlStudents(List<Student> sqlStudents, Scanner input, Student student) {
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of birth");
        student.setDateOfBirth();
        sqlStudents.add(student);
    }

    private static void addSqlStudentsPartTime(List<Student> sqlStudentsPartTime, Scanner input, Student student) {
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of birth");
        student.setDateOfBirth();
        sqlStudentsPartTime.add(student);
    }

    private static void addJavaStudentsPartTime(List<Student> javaStudentsPartTime, Scanner input, Student student) {
        System.out.println("Enter student's first name");
        student.setFirstName(input.next());
        System.out.println("Enter student's last name");
        student.setLastName(input.next());
        System.out.println("Enter student's date of birth");
        student.setDateOfBirth();
        javaStudentsPartTime.add(student);
    }

    private static void addAssignmentsToSql(List<Assignment> sqlAssignments, Scanner input, Assignment assignment) {
        System.out.println("Enter assignment's title");
        assignment.setTitle(input.next());
        System.out.println("Enter Assignment's submission date time");
        assignment.setSubDateTime();
        System.out.println("Enter Assignment's oral mark");
        assignment.setOralMark();
        System.out.println("Enter Assignment's total mark");
        assignment.setTotalMark();
        sqlAssignments.add(assignment);
    }

    private static void addAssignmentsToJava(List<Assignment> javaAssignments, Scanner input, Assignment assignment) {
        System.out.println("Enter assignment's title");
        assignment.setTitle(input.next());
        System.out.println("Enter Assignment's submission date time");
        assignment.setSubDateTime();
        System.out.println("Enter Assignment's oral mark");
        assignment.setOralMark();
        System.out.println("Enter Assignment's total mark");
        assignment.setTotalMark();
        javaAssignments.add(assignment);
    }

    private static void addSqlStudentsToList(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> sqlStudents) {
        sqlStudents.add(new Student("Antonis", "Antonioy", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Vasilis", "Vasileiou", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Kostas", "Kosta", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Apostolis", "Apostolidis", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Alex", "Alexiou", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Lampros", "Lamprou", "02-05-1931", 2500, sqlAssignments));
        sqlStudents.add(new Student("Makis", "Maki", "22-05-1991", 2500, sqlAssignments));
        sqlStudents.add(new Student("Giorgos", "Georgiou", "22-05-1991", 2500, sqlAssignments));

    }

    private static void addSqlStudentsPartTimeToList(List<Assignment> javaAssignments, List<Assignment> sqlAssignments, List<Student> sqlStudentsPartTime) {
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

    private static void addJavaStudentToList(List<Assignment> javaAssignments, List<Student> javaStudents) {
        javaStudents.add(new Student("Giannis", "Katsa", "12-01-1981", 2500, javaAssignments));
        javaStudents.add(new Student("Adreas", "Adreou", "22-05-1921", 2500, javaAssignments));
        javaStudents.add(new Student("Lampros", "Lamprou", "02-05-1931", 2500, javaAssignments));
        javaStudents.add(new Student("Makis", "Maki", "22-05-1991", 2500, javaAssignments));
        javaStudents.add(new Student("Giorgos", "Georgiou", "22-05-1991", 2500, javaAssignments));
        javaStudents.add(new Student("Kino", "Joker", "22-05-1991", 2500, javaAssignments));

    }

    private static void addJavaStudentPartTimeToList(List<Assignment> javaAssignments, List<Student> javaStudentsPartTime) {
        javaStudentsPartTime.add(new Student("Mixos", "Prinos", "12-01-1981", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Kostis", "Gianoy", "22-05-1921", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Asteris", "Mpampi", "02-05-1931", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Ken", "Babe", "22-05-1991", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Poli", "Jina", "22-05-1991", 2500, javaAssignments));
        javaStudentsPartTime.add(new Student("Makis", "Maki", "22-05-1991", 2500, javaAssignments));

    }

    private static void addSqlAssignmentsToList(List<Assignment> sqlAssignments) {
        sqlAssignments.add(new Assignment("Infrastructure", "Create a private School infrastructure", "18-11-2020", 100, 100));
        sqlAssignments.add(new Assignment("Terminal", "Create a hospital terminal", "12-12-2020", 100, 100));
        sqlAssignments.add(new Assignment("Elements", "Create a list of elements", "10-09-2021", 100, 100));
        sqlAssignments.add(new Assignment("React", "Create a website", "15-08-2021", 100, 100));
        sqlAssignments.add(new Assignment("DynamoDB", "Create a database", "20-07-2021", 100, 100));
    }

    private static void addAssignmentsToList(List<Assignment> javaAssignments) {
        javaAssignments.add(new Assignment("School", "Create a private School infrastructure", "18-10-2020", 100, 100));
        javaAssignments.add(new Assignment("Hospital", "Create a hospital terminal", "20-12-2020", 100, 100));
        javaAssignments.add(new Assignment("Elements", "Create a list of elements", "10-05-2021", 100, 100));
        javaAssignments.add(new Assignment("Website", "Create a website", "15-04-2021", 100, 100));
        javaAssignments.add(new Assignment("Database", "Create a database", "20-06-2021", 100, 100));
    }

    private static void addJavaTrainersToList(List<Trainer> javaTrainers) {
        javaTrainers.add(new Trainer("Vladimiros", "Fotiadis", "Java"));
        javaTrainers.add(new Trainer("Andreas", "Hliadis", "Python"));
    }

    private static void addTrainersToList(List<Trainer> sqlTrainers) {
        sqlTrainers.add(new Trainer("Nick", "Kalathis", "SQL"));
        sqlTrainers.add(new Trainer("Giorgos", "Paspalakis", "C#"));
    }
}






