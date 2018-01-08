// Driver for Employee hierarchy

//Mark Fitzgerald Student ID 15456198

// Java core packages
import java.text.DecimalFormat;
import java.util.ArrayList;

// Java extension packages
import javax.swing.JOptionPane;

import org.joda.time.LocalDate;
//import joda time


public class Test {

    // test Employee hierarchy
    public static void main(String args[]) {
        Employee employee; // superclass reference
        String output = "";
        ArrayList<Employee> emp = new ArrayList<Employee>();
        //create an ArrayList to store Employee Objects
        double monthlyWage;
        //create a variable to print monthlyWage
        
        Boss boss = new Boss("John", "Smith", 800.0, new LocalDate(2009, 07, 28));
        //create a Boss Object
        //using Joda Time Local date to pass in the date they joined

        CommissionWorker commissionWorker =
                new CommissionWorker("Sue", "Jones", 400.0, 3.0, -150, new LocalDate(2012, 02, 15));
        //create a CommissionWorker Object
        //using Joda Time Local date to pass in the date they joined
        //negative value for quantity passed in to test exception handling
        
        PieceWorker pieceWorker = new PieceWorker("Bob", "Lewis", -2.5, 200, new LocalDate(2014, 12, 01));
        //create a PieceWorker Object
        //using Joda Time Local date to pass in the date they joined
        //pass in a negative value for wage to test exception handling

        HourlyWorker hourlyWorker = new HourlyWorker("Karen", "Price", 13.75, 40, new LocalDate(2016, 05, 20));
        //create a hourlyWorker Object
        //using Joda Time Local date to pass in the date they joined
        
        DecimalFormat precision2 = new DecimalFormat("0.00");
        //used for precision
        
        emp.add(boss);
        emp.add(commissionWorker);
        emp.add(pieceWorker);
        emp.add(hourlyWorker);
        //add employee objects into ArrayList
        
        int i = 0;
        //create an incrementer 
        while(i<emp.size()) { //loop through the ArrayList
        	try { //try this for each Employee Object
            	if(emp.get(i).getJoinDate().isBefore(LocalDate.now().minusYears(5))) {
            		//if the employee is elegible for the bonus add this on
            		monthlyWage = (emp.get(i).earnings()) + 200;
            	} else {
            		//else get their normal salary
            		monthlyWage = (emp.get(i).earnings());
            	}
            
            	output += emp.get(i).toString() + " earned $"
                        + precision2.format(monthlyWage) + "\n"
                        + "The date the employee joined is: "
                        + emp.get(i).getJoinDate() + "\n"
                        + "Employee ID Number: " 
                        + emp.get(i).getMyID() + "\n";
            	//add all the details of the employee to output so we can print to screen 
        	}
        	catch(SalaryOutOfBoundsException e) {
        		//if the salary is a negative value throw an exception
                System.out.println("Exception thrown: " + e.getMessage());
                //print to screen that an exception is thrown and why
                //e.printStackTrace();
                //print the stack trace
        	}
        	i++; //increment i
        }
      
        JOptionPane.showMessageDialog(null, output,
                "Employee details",
                JOptionPane.INFORMATION_MESSAGE);
        //print the employee details to screen

        System.exit(0);
    }
} // end class Test
