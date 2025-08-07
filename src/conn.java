package Bank_Management_System.src;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "username", "password"); // change password
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

