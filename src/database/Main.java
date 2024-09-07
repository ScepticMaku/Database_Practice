package database;
import java.sql.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
            System.exit(0);
        }
        
        Add_Students add = new Add_Students();
        View_Table view = new View_Table();
        Update_Info upd = new Update_Info();
        Remove_Student rmv = new Remove_Student();
        Scanner sc = new Scanner(System.in);
        
        String transaction;
        
        System.out.println("Welcome to Student Information System!");
        
        do{
            System.out.print("""
                             1. Add Student Information
                             2. Update Student Information
                             3. View Student Information
                             4. Delete Student Information
                             Enter choice: """);
            try{
                int choice = sc.nextInt();

                switch(choice){
                    case 1:
                        add.addInfo();
                        break;
                    case 2:
                        upd.updateInfo();
                        break;
                    case 3:
                        view.viewTable();
                        break;
                    case 4:
                        rmv.removeStudent();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch(InputMismatchException e){
                System.out.println("InputMismatchException: Input must only be a number.");
            }
            
            System.out.print("\nMake another transaction? (yes/no): ");
            transaction = sc.next();
        } while(transaction.equals("yes"));
        System.out.println("See you next time!");
    }
        
}
