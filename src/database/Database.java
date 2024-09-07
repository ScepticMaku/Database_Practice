package database;
import java.sql.*;

public class Database {
    public static void main(String[] args) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        
        Grade gr = new Grade();
        Grades grs = new Grades();
        
//        gr.getGrades();
        grs.viewGrades();
        
        /*try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            System.out.println("Database connection successful!");
            
            Statement state = connect.createStatement();
            state.executeQuery("SELECT * FROM student.grades");
            ResultSet result = state.getResultSet();
            
            
            while(result.next()){
                System.out.println(result.getInt("ID"));
                System.out.println(result.getString("S_Name"));
                System.out.println(result.getDouble("Prelim"));
                System.out.println(result.getDouble("Midterm"));
                System.out.println(result.getDouble("Prefi"));
                System.out.println(result.getDouble("Final"));
            }
            
        } catch(SQLException e){
            System.out.println("Error while connecting to database.");
        }*/
        
        
        
    }
    
}
