package dao;

import beans.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDao {

    private String name;
    private double price;
    private int quantity;
    private int id;

    public ProductDao() {
    }

    public ProductDao(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductDao{name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> list() throws SQLException {
        List<Product> products = new ArrayList<Product>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = getConnection();
            PreparedStatement statement = con1.prepareStatement("SELECT  * FROM products");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return products;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/eshop1";
        String user = "root";
        String password = "CB12FT_Java!";
        return DriverManager.getConnection(url, user, password);
    }
}
