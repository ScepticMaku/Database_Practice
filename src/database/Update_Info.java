package database;
import java.sql.*;
import java.util.*;

public class Update_Info {
    public void updateInfo(){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement statement = connect.prepareStatement("SELECT S_Name FROM student.grades WHERE ID = ?");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("\nUpdate Student Information\n");
            
            String transaction;
            
            do{
                System.out.print("Enter ID you want to update: ");
                int id = sc.nextInt();
                
                statement.setInt(1,id);
                ResultSet result = statement.executeQuery();
                result.next();
                
                System.out.println("Selected Student: "+result.getString("S_Name")+"\n");
                
                System.out.print("""
                                 Select what you want to update: 
                                 1. Prelim
                                 2. Midterm
                                 3. Pre-final
                                 4. Final
                                 Enter selection: """);
                int selection = sc.nextInt();
                
                switch(selection){
                    case 1:
                        System.out.print("Enter new Prelim grade: ");
                        double grd_prelim = sc.nextDouble();
                        
                        PreparedStatement upd_prelim = connect.prepareStatement("UPDATE student.grades SET Prelim = ? WHERE ID = ?");
                        upd_prelim.setDouble(1, grd_prelim);
                        upd_prelim.setInt(2, id);
                        upd_prelim.executeUpdate();
                        
                        System.out.println("Prelim grade changed successfully!");
                        break;
                    case 2:
                        System.out.print("Enter new Midterm grade: ");
                        double grd_midterm = sc.nextDouble();
                        
                        PreparedStatement upd_midterm = connect.prepareStatement("UPDATE student.grades SET Midterm = ? WHERE ID = ?");
                        upd_midterm.setDouble(1, grd_midterm);
                        upd_midterm.setInt(2, id);
                        upd_midterm.executeUpdate();
                        
                        System.out.println("Midterm grade changed successfully!");
                        break;
                    case 3:
                        System.out.print("Enter new Pre-final grade: ");
                        double grd_prefi = sc.nextDouble();
                        
                        PreparedStatement upd_prefi = connect.prepareStatement("UPDATE student.grades SET Prefi = ? WHERE ID = ?");
                        upd_prefi.setDouble(1, grd_prefi);
                        upd_prefi.setInt(2,id);
                        upd_prefi.executeUpdate();
                        
                        System.out.println("Pre-final grade changed successfully!");
                        break;
                    case 4:
                        System.out.print("Enter new Final grade: ");
                        double grd_final = sc.nextDouble();
                        
                        PreparedStatement upd_final = connect.prepareStatement("UPDATE student.grades SET Final = ? WHERE ID = ?");
                        upd_final.setDouble(1, grd_final);
                        upd_final.setInt(2, id);
                        upd_final.executeUpdate();
                        
                        System.out.println("Final grade changed successfully!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                System.out.print("Do you want to edit another? (yes/no): ");
                transaction = sc.next();
            } while(transaction.equals("yes"));
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
        }
    }
}
