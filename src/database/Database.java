package database;
import java.sql.*;

public class Database {
    public static void main(String[] args) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        
        Grade gr = new Grade();
        Grades grs = new Grades();
        
        gr.getGrades();
    }
}
