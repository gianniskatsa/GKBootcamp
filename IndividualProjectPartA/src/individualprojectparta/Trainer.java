package individualprojectparta;

public class Trainer {
    private String subject;
    private String firstName;
    private String lastName;

    public Trainer(String surname, String name, String subject) {
        this.subject = subject;
        this.firstName = name;
        this.lastName = surname;
    }
    public Trainer(){}

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}