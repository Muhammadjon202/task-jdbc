import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jdbcUrl = "jdbc:postgresql://localhost:5432/information-db";
        String username = "postgres";
        String pass = "0000";
        System.out.println("Enter Your First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Your Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Your Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter Your Phone Number: ");
        long phoneNum = scanner.nextLong();
        scanner.nextLine();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, pass);
            Statement statement = connection.createStatement();
            String sql = "insert into students_info(first_name, last_name, gender, phone_num)" +
                    "values('" + firstName + "', '" + lastName + "', '" + gender + "', " + phoneNum + ")";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error Connection");
            e.printStackTrace();
        }
    }
}
