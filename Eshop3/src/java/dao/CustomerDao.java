package dao;

import beans.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDao {

    private String firstName;
    private String lastName;
    private int id;

    public CustomerDao() {
    }

    public CustomerDao(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CustomerDao{firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Customer> list() throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = getConnection();
            PreparedStatement statement = con1.prepareStatement("SELECT  id, first_name, last_name FROM customers");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customers.add(customer);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/eshop1";
        String user = "root";
        String password = "CB12FT_Java!";
        return DriverManager.getConnection(url, user, password);
    }
}
