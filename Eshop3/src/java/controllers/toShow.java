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
import java.util.Date;

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
        printingHtmlGet(out);
        try {
            List<Customer> customers = customerDao.list();
            enterCustomers(out, customers);
            List<Product> products = productDao.list();
            enterMoreProducts(products, out);
        } catch (SQLException ex) {
            Logger.getLogger(toShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        printingHtmlGet2(out);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductDao> products = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (request.getParameter("checkpr" + i) != null && parseInt(request.getParameter("quantity" + i)) != 0) {
                products.add(new ProductDao(parseInt(request.getParameter("product" + i)),
                        request.getParameter("product" + i), parseInt(request.getParameter("price" + i)),
                        parseInt(request.getParameter("quantity" + i))));
                System.out.println(products);
            }
        }
        double totalPrice = sumProductsPrices(products);
        System.out.println(totalPrice);

        if ((request.getParameter("check1") != null)) {
            int customerId = parseInt(request.getParameter("customer1"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        } else if ((request.getParameter("check2") != null)) {
            int customerId = parseInt(request.getParameter("customer2"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        } else if ((request.getParameter("check3") != null)) {
            int customerId = parseInt(request.getParameter("customer3"));
            int order2id = insertIntoOrders2(customerId, totalPrice);
            for (ProductDao productDao : products) {
                insertIntoOrders2Details(order2id, productDao.getId(), productDao.getPrice(), productDao.getQuantity());
            }
        }
        printingHtmlPost(response);

    }

    private void enterCustomers(PrintWriter out, List<Customer> customers) {
        out.println("<div class='col-md-12'>");
        out.println("<h4>Please tick 1 customer to select him</h4>");
        out.println("<form method=\"POST\">");
        out.println(" <div class=\"row\">");

        for (int i = 1; i < customers.size(); i++) {
            for (Customer customerDao : customers) {
                out.println("<div class='col-md-4'>");
                int customerId = customerDao.getId();
                String firstName = customerDao.getFirstName();
                String lastName = customerDao.getLastName();
                out.println("</br><input type='checkbox'  " + "name=check" + i + ">");
                out.println("<input  " + "name='customer" + i + "'" + " type=\"text\" value='" + customerId + ") " + firstName + " " + lastName + "'></br>");
                i++;
                out.println("</div>");

            }
        }
        out.println("</div>");
    }

    private int enterMoreProducts(List<Product> products, PrintWriter out) {
        int result = 0;

        out.println("</br><h4 >Please tick the products you want to submit and enter their quantities </h4>");
        out.println("</br></br> <div class=\"row\">");
        for (int i = 0; i < 1; i++) {
            for (Product productDao : products) {
                out.println("<div class='col-md-4'>");
                int productId = productDao.getId();
                String name = productDao.getName();
                double price = productDao.getPrice();
                int quantity = productDao.getQuantity();
                out.println("</br><input  " + "name='product" + i + "'" + " type=\"text\" value='" + productId + ") " + name + " " + "'></br>");
                out.println("</br><input placeholder='Enter quantity' " + "name='quantity" + i + "'" + " type=\"number\" \" \n" + "+value='" + quantity + "' >");
                out.println("</br></br><input type='checkbox'  value='checked' " + "name=checkpr" + i + ">");
                out.println("<input hidden " + "name='price" + i + "'" + " type=\"text\" value='" + price + " " + "'></br>");
                out.println("</div>");
                i++;
            }

        }
        out.println("</div>");
        out.println("</div>");
        return result;
    }

    private void printingHtmlGet(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Precious Eshop</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n" + "");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-12\">");
        out.println("<div class=\"jumbotron text-center\" id=\"jumb\">");
        out.println("<h1>My Preciousss E-shop</h1>");
        out.println("<p>Don't buy the Ring ;)</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

    }

    private void printingHtmlGet2(PrintWriter out) {
        out.println("<div class='row'>");
        out.println("<div class=\"col-md-4\">");
        out.println("</div>");
        out.println("<div class=\"col-md-4\">");
        out.println("</br></br> <input class=\" btn btn-outline-danger my-2 my-sm-0 \" type=\"submit\" value=\"submit\" name=\"sumbit\" />\n");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private void printingHtmlPost(HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Precious Eshop</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\n" + "");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"row\">");
            out.println("<div class=\"col-md-12\">");
            out.println("<div class=\"jumbotron text-center\" id=\"jumb\">");
            out.println("<h1>My Preciousss E-shop</h1>");
            out.println("<p>Don't buy the Ring ;)</p>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<h2> Your submission has been inserted into the database!</h2>");

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
        java.sql.Timestamp date = getCurrentTimeStamp();
        try {
            Connection con1 = getConnection();
            String sql1 = "insert into oders2(date, customers_id, total_price) values(?, ?, ?)";
            PreparedStatement stmt1 = con1.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            stmt1.setTimestamp(1, date);
            stmt1.setInt(2, customerId);
            stmt1.setDouble(3, totalPrice);
            stmt1.execute();
            ResultSet rs1 = stmt1.getGeneratedKeys();
            rs1.next();
            productId = rs1.getInt(1);
            System.out.println("productId");

        } catch (SQLException e) {
            Logger.getLogger(toShow.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return productId;
    }

    public int insertIntoOrders2Details(int orders2Id, int productsId, double price, int quantity) {
        int result = 0;
        try {
            Connection con1 = getConnection();
            String sql1 = "insert into orders2_details(orders2_id, products_id, price, quantity) values(?, ?, ?, ?)";
            PreparedStatement stmt1 = con1.prepareStatement(sql1);
            stmt1.setInt(1, orders2Id);
            stmt1.setInt(2, productsId);
            stmt1.setDouble(3, price);
            stmt1.setInt(4, quantity);
            stmt1.execute();
        } catch (SQLException e) {
            Logger.getLogger(toShow.class
                    .getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    private static Timestamp getCurrentTimeStamp() {
        Date today = new Date();
        return new Timestamp(today.getTime());
    }
}
