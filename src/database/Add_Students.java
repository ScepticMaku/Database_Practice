package database;
import java.sql.*;
import java.util.*;

public class Add_Students {
    public void addInfo() {
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM student.grades");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("\nAdd Student Information.\n");
            System.out.print("Enter number of students to add: ");
            int stud = sc.nextInt();
            
            
            for(int i = 0; i < stud; i++){
                System.out.println("Enter details of student: "+(i+1));
                
                System.out.print("ID: ");
                int sid = sc.nextInt();
                System.out.print("Name: ");
                String sname = sc.next();
                System.out.print("Prelim: ");
                double spre = sc.nextDouble();
                System.out.print("Midterm: ");
                double smid = sc.nextDouble();
                System.out.print("Prefi: ");
                double sprefi = sc.nextDouble();
                System.out.print("Final: ");
                double sfinal = sc.nextDouble();
                
                processInfo(sid, sname, spre, smid, sprefi, sfinal);
            }
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
        }
    }
    
    public void processInfo(int id, String name, double pre, double mid, double prefi, double fin){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement statement = connect.prepareStatement("INSERT INTO student.grades VALUES(?,?,?,?,?,?,?,?)");
            
            double average = (pre + mid + prefi + fin)/4;
            String remarks = (average > 3.0) ? "Failed" : "Passed";
            
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, pre);
            statement.setDouble(4, mid);
            statement.setDouble(5, prefi);
            statement.setDouble(6, fin);
            statement.setDouble(7, average);
            statement.setString(8, remarks);
            
            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
        }
    }
}