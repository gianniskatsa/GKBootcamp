package controllers;

import beans.Customer;
import beans.Product;
import dao.CustomerDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giannis
 */
@WebServlet(name = "toShow", urlPatterns = {"/"})
public class toShow extends HttpServlet {

    private CustomerDao customerDao;
    private ProductDao productDao;

    @Override
    public void init() {
        customerDao = new CustomerDao();
        productDao = new ProductDao();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Precious Eshop</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n" + "");
        out.println("</head>");
        out.println("<body>");
        out.println("<h4>Please UNtick 1 customer to select him</h4>");
        try {
            List<Customer> customers = customerDao.list();
            out.println("<form method=\"POST\">");
            for (int i = 1; i < customers.size(); i++) {
                for (Customer customerDao : customers) {

                    int customerId = customerDao.getId();
                    String firstName = customerDao.getFirstName();
                    String lastName = customerDao.getLastName();
                    out.println("</br><input type='checkbox' checked " + "name=check" + i + "'" + ">");
                    out.println("<input  " + "name='customer" + i + "'" + " type=\"text\" value='" + customerId + ") " + firstName + " " + lastName + "'></br>");
                    i++;
                }
            }
            out.println("<h4>Select Product</h4>");
            List<Product> products = productDao.list();
            enterMoreProducts(products, out);
//        out.println(" <input class=\"btn btn-outline-danger my-2 my-sm-0\" value=\"more\" name=\"more\" onclick="+enterMoreProducts(products, out)+ ">\n");

        } catch (SQLException ex) {
            Logger.getLogger(toShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(" <input class=\"btn btn-outline-danger my-2 my-sm-0\" type=\"submit\" value=\"submit\" name=\"sumbit\" />\n");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    private int enterMoreProducts(List<Product> products, PrintWriter out) {
        int result = 0;
        for (int i = 0; i < 1; i++) {
            for (Product productDao : products) {

                int productId = productDao.getId();
                String name = productDao.getName();
                double price = productDao.getPrice();
                int quantity = productDao.getQuantity();
//                 out.println("<h6> Please select checkbox to include or not </h6></br>");
                out.println("</br>Add<input type='checkbox' checked value='checked' " + "name=checkpr" + i + "'" + ">");
//                out.println("</br>Don't add<input type='radio' value='unchecked' " + "name=checkpr" + i + "'" + ">");
                out.println("<input  " + "name='product" + i + "'" + " type=\"text\" value='" + productId + ") " + name + " " + "'></br>");
                out.println("<input " + "name='quantity" + i + "'" + " type=\"number\" \" \n" + "+value='" + quantity + "' >");
                out.println("<input hidden " + "name='price" + i + "'" + " type=\"text\" value='" + price + " " + "'></br>");

                i++;
            }
        }
        return result;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("customer1"));
        System.out.println(request.getParameter("quantity1"));

        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        List<ProductDao> products = new ArrayList<ProductDao>();
//        String radio=request.getParameter("checkpr0");
//        System.out.println(radio);
//        if(radio.equals("checked")){
//            System.out.println("it was selected");
//        }else{System.out.println("not selected");}
        
        
        
        
        for (int i = 0; i < 3; i++) {
            if (request.getParameter("checkpr" + i) == null) {
                products.add(new ProductDao(parseInt(request.getParameter("product" + i)),
                        request.getParameter("product" + i), parseInt(request.getParameter("price" + i)),
                        parseInt(request.getParameter("quantity" + i))));
                System.out.println(products);
            }
        }
       
        double totalPrice = sumProductsPrices(products);
        System.out.println(totalPrice);
        if ((request.getParameter("check1") == null)) {
            int customerId = parseInt(request.getParameter("customer1"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        } else if ((request.getParameter("check2") == null)) {
            int customerId = parseInt(request.getParameter("customer2"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        } else if ((request.getParameter("check3") == null)) {
            int customerId = parseInt(request.getParameter("customer3"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        }
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/eshop1";
        String user = "root";
        String password = "CB12FT_Java!";
        return DriverManager.getConnection(url, user, password);
    }

    public double sumProductsPrices(List<ProductDao> products) {
        double result = 0;
        for (ProductDao productDao : products) {
            result += productDao.getPrice() * productDao.getQuantity();
        }
        return (result);
    }

    public int parseInt(String x) {
        int thisInt = 0;
        try {
            thisInt = ((Number) NumberFormat.getInstance().parse(x)).intValue();

        } catch (ParseException ex) {
            Logger.getLogger(toShow.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return thisInt;
    }

    public int insertIntoOrders2(int customerId, double totalPrice) {
        int productId = 0;
        PreparedStatement stmt1 = null;
        java.sql.Timestamp date = getCurrentTimeStamp();
        try {
            Connection con1 = getConnection();
            String sql1 = "insert into oders2(date, customers_id, total_price) values(?, ?, ?)";
            stmt1 = con1.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            stmt1.setTimestamp(1, date);
            stmt1.setInt(2, customerId);
            stmt1.setDouble(3, totalPrice);
            stmt1.execute();
            ResultSet rs1 = stmt1.getGeneratedKeys();
            while (rs1.next()) {
                productId = rs1.getInt(1);
                System.out.println("productId");
            }
        } catch (SQLException e) {
            Logger.getLogger(toShow.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return productId;
    }

    public int insertIntoOrders2Details(int orders2Id, int productsId, double price, int quantity) {
        int result = 0;
        PreparedStatement stmt1 = null;
        java.sql.Timestamp date = getCurrentTimeStamp();
        try {
            Connection con1 = getConnection();
            String sql1 = "insert into orders2_details(orders2_id, products_id, price, quantity) values(?, ?, ?, ?)";
            stmt1 = con1.prepareStatement(sql1);
            stmt1.setInt(1, orders2Id);
            stmt1.setInt(2, productsId);
            stmt1.setDouble(3, price);
            stmt1.setInt(4, quantity);
            stmt1.execute();
            ResultSet rs1 = stmt1.getGeneratedKeys();
        } catch (SQLException e) {
            Logger.getLogger(toShow.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
