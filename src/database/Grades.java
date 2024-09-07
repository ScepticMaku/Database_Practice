package database;
import java.sql.*;

public class Grades {
    
    int s_id;
    String sname, remarks;
    double prel, midt, prefi, fina;
    double AVERAGE;
    
    public void addGrades(int id, String name, double p, double m, double pf, double f) throws SQLException {
        
        this.s_id = id;
        this.sname = name;
        this.prel = p;
        this.midt = m;
        this.prefi = pf;
        this.fina = f;
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        PreparedStatement state = connect.prepareStatement("INSERT INTO student.grades VALUES(?,?,?,?,?,?,?,?)");

        double ave = (p + m + pf + f)/4;
        String rem = (ave > 3.0) ? "Failed" : "Passed";

        state.setInt(1, this.s_id);
        state.setString(2, this.sname);
        state.setDouble(3, this.prel);
        state.setDouble(4, this.midt);
        state.setDouble(5, this.prefi);
        state.setDouble(6, this.fina);
        state.setDouble(7, ave);
        state.setString(8, rem);

        state.executeUpdate();
    }
    
    public void viewGrades() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        PreparedStatement state = connect.prepareStatement("SELECT * FROM student.grades");
        
        ResultSet result = state.executeQuery();
        
        double TCA = 0;
        int passed = 0;
        int failed = 0;
        int s=0;
    
        while(result.next()){
            
            this.s_id = result.getInt("ID");
            this.sname = result.getString("S_name");
            this.prel = result.getDouble("Prelim");
            this.midt = result.getDouble("Midterm");
            this.prefi = result.getDouble("Prefi");
            this.fina = result.getDouble("Final");
            this.AVERAGE = result.getDouble("Average");
            this.remarks = result.getString("Remarks");

            System.out.printf("%-5d %-10s %-5.1f %-5.1f %-5.1f %-5.1f %-5.1f %s\n", s_id, sname, prel, midt, prefi, fina, AVERAGE, remarks);
            
            TCA += this.AVERAGE;
            
            if(this.AVERAGE > 3.0){
                failed++;
            } else{
                passed++;
            }
            
            s++;
        }
        
        System.out.println("\n--------------------------------------"
                + "\nNo. of students: "+s);
        System.out.printf("Total class average: %.1f",TCA/s);
        System.out.println("\nNo. of passed: "+passed
                + "\nNo. of failed: "+failed);
    }
}
