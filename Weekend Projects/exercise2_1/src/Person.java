import java.util.Scanner;

public class Person {
    String name = null;

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public int getAge() {

        return age;
    }

    public void setNewAge() {
        boolean flag;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                this.age = sc.nextInt();
                flag = false;
            } catch (Exception e) {
                System.err.println("Invalid integer value. ");
                System.out.println("Please enter a correct age.");
                flag = true;
            }
        }while(flag);
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Pets extends Person {

    String nickname = null;
    String type = null;

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }


    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

}







