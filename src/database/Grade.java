package database;
import java.util.Scanner;
import java.sql.*;

public class Grade {
    
    double TCA = 0;
    int passed = 0;
    int failed = 0;
    int s=1;
        
    public void getGrades() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        PreparedStatement state = connect.prepareStatement("SELECT * FROM student.grades");
        
        ResultSet result = state.executeQuery();
        
        Scanner sc = new Scanner(System.in);
        Grades grs = new Grades();
        
        System.out.println("Running Grade program: \n");
        System.out.print("Enter no. of students: ");
        int snum = sc.nextInt();
        
        for(int i = 0; i < snum; i++){
            System.out.println("Enter details of student "+(i+1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Prelim: ");
            double pre = sc.nextDouble();
            System.out.print("Midterm: ");
            double mid = sc.nextDouble();
            System.out.print("Prefi: ");
            double pref = sc.nextDouble();
            System.out.print("Final: ");
            double fin = sc.nextDouble();
            
            grs.addGrades(id, name, pre, mid, pref, fin);
        }
        
        System.out.printf("\n%-5s %-10s %-5s %-5s %-5s %-5s %-5s %-5s\n", "ID", "Student", "Pre", "Mid", "Prefi", "Final", "Average", "Remarks");
        
        grs.viewGrades();
        /*for(int i = 0; i < snum; i++){
            gr[i].AVERAGE = (gr[i].PRE+gr[i].MID+gr[i].PREFI+gr[i].FIN)/4;
            TCA = TCA + gr.AVERAGE;
            gr[i].viewGrades();
            
            if(gr[i].AVERAGE > 3.0){
                failed++;
            } else{
                passed++;
            }
        }*/
        
        /*while(result.next()){
            
            TCA = TCA + grs.AVERAGE;
            grs.viewGrades();
            
            if(grs.AVERAGE > 3.0){
                failed++;
            } else{
                passed++;
            }   
            
            s++;
        }*/
        
        /*System.out.println("\n--------------------------------------");
        System.out.println("No. of students: "+snum);
        System.out.println("Total Class Average: "+TCA/snum);
        System.out.println("No. of Passed: "+passed);
        System.out.println("No. of Failed: "+failed);*/
    }
}
