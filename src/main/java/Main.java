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
        System.out.println("Enter Your Class Name: ");
        String class_name = scanner.nextLine();
        System.out.println("Enter Your Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter Your Phone Number: ");
        long phoneNum = scanner.nextLong();
        scanner.nextLine();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, pass);
            PreparedStatement stmt = connection.prepareStatement("insert into students_info values(?,?,?,?,?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, class_name);
            stmt.setString(4, gender);
            stmt.setLong(5, phoneNum);
            PreparedStatement statement = connection.prepareStatement("insert into student_subjects values(?)");
            int a = 0;
            while(a < 1) {
                System.out.println("1. Set Subject Info");
                System.out.println("2. Stop");
                int btn = scanner.nextInt();
                scanner.nextLine();
                if (btn == 1) {
                    System.out.println("Enter Your Subject: ");
                    String setSubject = scanner.nextLine();
                    statement.setString(1, setSubject);
                } else if (btn == 2) {
                    a = 2;
                } else {
                    System.out.println("Incorrect");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Connection");
            e.printStackTrace();
        }

    }
}
