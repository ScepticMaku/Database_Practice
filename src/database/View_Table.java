package database;
import java.sql.*;

public class View_Table {
    public void viewTable(){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
            PreparedStatement statement = connect.prepareStatement("SELECT * FROM student.grades");
            ResultSet result = statement.executeQuery();
            
            double TCA = 0;
            int passed = 0;
            int failed = 0;
            int s = 0;
            
            System.out.println("\nView Student Information\n");
            System.out.println("--------------------------------------");
            System.out.printf("\n%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Student", "Pre", "Mid", "Prefi", "Final", "Average", "Remarks");
            
            while(result.next()){
                int s_id = result.getInt("ID");
                String s_name = result.getString("S_Name");
                double s_prelim = result.getDouble("Prelim");
                double s_midterm = result.getDouble("Midterm");
                double s_prefi = result.getDouble("Prefi");
                double s_final = result.getDouble("Final");
                double s_average = result.getDouble("Average");
                String s_remarks = result.getString("Remarks");
                
                System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", s_id, s_name, s_prelim, s_midterm, s_prefi, s_final, s_average, s_remarks);
                
                TCA += s_average;
                
                if(s_average > 3.0){
                    failed++;
                } else{
                    passed++;
                }
                s++;
            }
            
            System.out.println("""
                               --------------------------------------
                               No. of students: """+s);
            System.out.printf("Total class average: %.1f",TCA/s);
            System.out.println("\nNo. of passed: "+passed
                    + "\nNo. of failed: "+failed);
            
        } catch(SQLException e){
            System.out.println("SQLException: "+e.getMessage());
        }
    }
}
