package beans;

public class Customer {

    private String firstName;
    private String lastName;
    private String tel;
    private String email;
    private int id;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String tel, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

}
