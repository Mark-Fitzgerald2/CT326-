import org.joda.time.LocalDate;

//Mark Fitzgerald Student ID 15456198

// Abstract base class Employee.

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDate joinDate;
    //create a LocalDate variable to store the joinDate
    private static long IDNumber = 1;
    //start IDNumber at the value 1 for the first employee
    private long myID = 0; 
    //create a variable to return an employee's specific ID
   

    // constructor
    public Employee(String first, String last, LocalDate date) {
    	//note that the joinDate is passed in through the constructor
        firstName = first;
        lastName = last;
        joinDate = date;
        //store the date they joined in a local variable 
        this.myID = IDNumber;
        //give an employee their specific ID
        IDNumber++;
        //increment the IDNumber variable everytime an ID is used
        //this is to make sure no two employee's have the same ID
    }
    
    //get IDNumber
    public long getMyID() {
    	return myID; 
    	//this is used to return an employee's specific ID Number
    }
    
    //get join date
    public LocalDate getJoinDate() {
    	return joinDate; 
    	//this is used to return the specific date an employee joined the company
    }

    // get first name
    public String getFirstName() {
        return firstName;
        //this is used to return an Employee's first name
    }

    // get last name
    public String getLastName() {
        return lastName;
      //this is used to return an Employee's second name
    }

    public String toString() {
        return firstName + ' ' + lastName;
        //used to print an employee's first and second name
    }

    public abstract double earnings() throws SalaryOutOfBoundsException; 
    //throws an exception to handle negative salary values
}
