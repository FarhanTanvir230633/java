import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudent {

    public static void main(String[] args) {

        String url = "jdbc:ucanaccess://Student.accdb";

        String insertSQL =
            "INSERT INTO student (Name, Email, Phone) VALUES (?, ?, ?)";

        try {

            Connection con = DriverManager.getConnection(url);

            PreparedStatement ps = con.prepareStatement(insertSQL);

            // Person 1
            ps.setString(1, "Yasir Arafat");
            ps.setString(2, "yasir@pust.ac.bd");
            ps.setString(3, "01712345678");
            ps.executeUpdate();

            // Person 2
            ps.setString(1, "Rahim Ahmed");
            ps.setString(2, "rahim@gmail.com");
            ps.setString(3, "01812345678");
            ps.executeUpdate();

            System.out.println("Two records inserted successfully.");

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}