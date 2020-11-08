import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class exercise2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Pets> Pet = new ArrayList();
        Pets pet1 = new Pets();
        pet1.setName("Giannis");
        pet1.setAge(25);
        pet1.setNickname("Bilbo");
        pet1.setType("Bear");
        Pet.add(pet1);

        Pets pet2 = new Pets();
        pet2.setName("Kostas");
        pet2.setAge(45);
        pet2.setNickname("Mamra");
        pet2.setType("Lion");
        Pet.add(pet2);

        Pets pet3 = new Pets();
        pet3.setName("Antonis");
        pet3.setAge(19);
        pet3.setNickname("Frodo");
        pet3.setType("Fish");
        Pet.add(pet3);

        System.out.println("Welcome to the family members and pets terminal ");
        System.out.println("Would you like to enter some more family members? Choose Y/N  ");
        String firstDecision = input.next();
        if (firstDecision.contains("Y")) {
            System.out.println("Please enter the number of people to add:");
            boolean flag;
            do {
                try {
                    Scanner sc = new Scanner(System.in);
                    int countPets = sc.nextInt();
                    flag = false;
                    for (int i = 0; i < countPets; i++) {
                        Pets newPets = new Pets();

                        System.out.println("Enter details for person: " + (i + 1));

                        System.out.println("Enter Name: ");
                        newPets.setName(input.next());

                        System.out.println("Enter Age: ");
                        newPets.setNewAge();
                        System.out.println("Does he/she have a pet? Answer with Y/N");
                        String petDecision = input.next();

                        if (petDecision.contains("Y")) {
                            System.out.println("Enter Pet's Name");
                            newPets.setNickname(input.next());
                            System.out.println("Enter Pet's type");
                            newPets.setType(input.next());
                        } else {
                            System.out.println(newPets.getName() + " doesn't have a pet" + "\n");
                        }

                        Pet.add(newPets);
                    }
                } catch (Exception e) {
                    System.err.println("Invalid integer value. ");
                    System.out.println("Please enter a correct value.");
                    flag = true;

                }
            }
            while(flag);
        }
        System.out.println("Please choose between the next options(A,B,C): " + "\n" +
                " A) Print a list of all the family members and their pets  " + "\n" +
                " B) Print a list of all the family members  ");

        String secondDecision = input.next();
        switch (secondDecision) {
            case "A":
                for (Pets pet : Pet) {
                    if (pet.getNickname() != null) {

                        System.out.println("The person's name is " + pet.getName() + "\n" + "His/Her age is "
                                + pet.getAge() + "\n"
                                + "His/Her pet is a type of " + pet.getType() + "\n" + "His/Her pet's nickname is "
                                + pet.getNickname() + "\n");
                    } else {
                        System.out.println("The person's name is " + pet.getName() +
                                "\n" + "His/Her age is " + pet.getAge()
                                + " and has no pet " + "\n");
                    }
                }
                break;
            case "B":
                for (Pets pet : Pet) {
                    System.out.println("The person's name is " + pet.getName() + " and his/her age is " +
                            pet.getAge() + "\n");
                }
                break;
        }
    }
}
