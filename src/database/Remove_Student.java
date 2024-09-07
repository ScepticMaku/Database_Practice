package database;
import java.sql.*;
import java.util.*;

public class Remove_Student {
    public void removeStudent(){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM student.grades WHERE ID = ?");
            Scanner sc = new Scanner(System.in);
            System.out.println("\nDelete Student Information");
            
            String transaction;
            
            do{
                System.out.print("\nEnter ID you want to delete: ");
                int id = sc.nextInt();
                
                statement.setInt(1,id);
                ResultSet result = statement.executeQuery();
                result.next();
                
                System.out.println("Selected Student: "+result.getString("S_Name"));
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String confirm = sc.next();
                
                if(confirm.equals("yes")){
                    PreparedStatement remove = connect.prepareStatement("DELETE FROM student.grades WHERE ID = ?");
                    remove.setInt(1, id);
                    remove.execute();
                    System.out.println("Student removed successfully!");
                } else{
                    System.out.println("Deletion cancelled.");
                }
                
                System.out.print("Do you want to delete another? (yes/no): ");
                transaction = sc.next();
            } while(transaction.equals("yes"));
            
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
        }
    }
}
