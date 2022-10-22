import java.util.Scanner;
import java.util.ArrayList;

/*
* MAIN CLASS WHERE ALL THE USER INTERACTION AND METHOD CALLS ARE MADE. THIS CONSISTS OF METHODS ALLOWING USER
* INPUT AND ACCESSING THE EmployeeRegistry CLASS TO INTERACT WITH THE OTHER CLASSES
*/

public class Main {

    private static EmployeesRegistry registry = new EmployeesRegistry();

    /*
    * THIS IS THE CONSTRUCTOR OF THE CLASS THAT MAKES AN INSTANCE OF THE EmployeesRegistry CLASS
    * TO BE USED FOR DATA ACCESS
    */
    public Main(){
        this.registry = new EmployeesRegistry();
    }

    // METHOD THAT ALLOWS USER STRING ENTRY VIA KEYBOARD
    public String inputString(String input){
        Scanner scanner = new Scanner(System.in);

        System.out.print(input);
        String output = (scanner.nextLine().trim().toLowerCase());

        // RETURNS NULL IF THE INPUT IS NOT VALID OR IS EMPTY, ELSE RETURNS THE INPUT FROM THE USER
        if (output == "" || output == null){
            System.out.println("\nDo not leave blank\n");
            return null;
        }else if (validString(output) == false) {
            System.out.println("\nEnter data correctly\n");
            return null;
        }else
            return output;
    }

    // METHOD WHICH CHECKS IN USER STRING INPUT IS INVALID
    public static boolean validString(String input) {

        // CHECKS THE INPUT IS ALPHABETICAL USING REGEX
        boolean result = input.matches("[a-zA-Z]+");
        if (result == true)
            return true;
        else
            return false;
    }

    // METHOD THAT TAKES IN USER INTEGER ENTRY VIA KEYBOARD
    public int inputInt(String input){
        Scanner scanner = new Scanner(System.in);

        System.out.print(input);
        int output = scanner.nextInt();

        return output;
    }

    // METHOD FOR MAIN MENU FOR USER NAVIGATION THAT THROWS EXCEPTION IF INPUT IS INVALID
    public int menu() throws Exception{

        int selection;

        // DISPLAYS A MENU USING PRINT STATEMENTS
        System.out.println("1. Employ someone new");
        System.out.println("2. Change Manager");
        System.out.println("3. Get employee info");
        System.out.println("4. Return employees");
        System.out.println("5. Go to Sales section");
        System.out.println("6. Go to HR section");
        System.out.println("7. QUIT\n");

        // ASKS USER TO INPUT A VALUE UNTIL IT IS IN THE REQUIRED RANGE
        do {
            selection = inputInt("Select an option: ");
        }while (selection < 1 || selection > 7);

        // RETURNS THE USER INPUT IF IN THE RANGE OR THROWS AN EXCEPTION IF NOT
        if (!(selection < 1) || !(selection > 7))
            return selection;
        else
            throw new Exception("\nEnter an integer\n");

    }

    /*
    * METHOD WHICH IS CALLED IN ORDER TO HIRE A NEW EMPLOYEE
    * WITH THE USE OF POLYMORPHISM
    */
    public void employSomeone(){
        String name = inputString("Enter the name: ");

        if (name == null)
            return;

        // ASKS USER TO INPUT A DEPARTMENT NAME UNTIL IT IS A VALID DEPARTMENT
        boolean valid = false;
        do {
            String department = inputString("Enter department (Sales or HR): ");

            if (department == null){
                System.out.println("Enter valid department");
            }
            else if (department.equals("sales")) {
                Employee e = new Sales(name);
                registry.addSalesEmployee(e);
                valid = true;
            }
            else if (department.equals("hr")) {
                Employee e = new HR(name);
                registry.addHrEmployee(e);
                valid = true;
            }
            else
                System.out.println("Please enter a valid department");
        }while (valid == false);

    }

    // METHOD THAT CHANGES THE MANAGER OF THE BUSINESS
    public void changeManager(){
        ArrayList<Employee> list = registry.returnAllEmployees();

        // ASKS USER TO ENTER AN EMPLOYEE ID UNTIL A VALID ID IN RANGE IS ENTERED
        int id;
        do {
            id = inputInt("Enter the id of the employee: ");
        }while (id < 0 || id >= list.size());

        // RETRIEVES EMPLOYEE OBJECT THEN CALLS THE changeManager METHOD
        Employee e = list.get(id);

        registry.changeManager((Manager) e);
    }

    // METHOD WHICH RETURNS THE EMPLOYEE ID AND NAME
    public void getEmployeeInfo(){
        ArrayList<Employee> list = registry.returnAllEmployees();

        // ASKS USER TO ENTER AN EMPLOYEE ID UNTIL A VALID ID IN RANGE IS ENTERED
        int id;
        do {
            id = inputInt("Enter the id of the employee: ");
        }while (id < 0 || id >= list.size());

        // RETRIEVES EMPLOYEE OBJECT THEN PRINTS INFORMATION
        Employee e = list.get(id);

        System.out.println("\n"+registry.getEmployeeInfo(e)+"\n");
    }

    // MENU WHICH ALLOWS USER TO RETRIEVE CERTAIN EMPLOYEES IN THE BUSINESS
    public void returnEmployeesMenu(){
        int selection;

        // DISPLAYS A MENU USING PRINT STATEMENTS
        System.out.println("1. Get All Employees");
        System.out.println("2. Get Sales Employees");
        System.out.println("3. Get HR Employees");
        System.out.println("4. Get number of employees");
        System.out.println("5. QUIT\n");

        // ASKS USER TO INPUT A VALUE UNTIL IT IS IN THE REQUIRED RANGE THEN CALLS CORRESPONDING METHOD
        do {
            selection = inputInt("Select an option: ");
        }while (selection < 1 || selection > 5);

        switch (selection){
            case 1:
                returnAllEmployees();
                break;
            case 2:
                returnSalesEmployees();
                break;
            case 3:
                returnHrEmployees();
                break;
            case 4:
                returnNumberOfEmployees();
                break;
            case 5:
                break;
        }

        return;
    }

    // METHOD WHICH RETURNS ALL THE EMPLOYEES
    public void returnAllEmployees(){
        // GET ARRAYLIST OF ALL EMPLOYEES
        ArrayList<Employee> list = registry.returnAllEmployees();
        System.out.println();

        // LOOPS THROUGH ARRAYLIST AND PRINTS INFORMATION ON ALL
        for (Employee e : list)
            System.out.println(registry.getEmployeeInfo(e));
    }

    // METHOD WHICH RETURNS AND PRINTS THE SALES EMPLOYEES INFORMATION
    public void returnSalesEmployees(){
        ArrayList<Employee> list = registry.returnSalesEmployees();
        System.out.println();

        for (Employee e : list)
            System.out.println(registry.getEmployeeInfo(e)+"\n");
    }

    // METHOD WHICH RETURNS AND PRINTS THE HR EMPLOYEES INFORMATION
    public void returnHrEmployees(){
        ArrayList<Employee> list = registry.returnHrEmployees();
        System.out.println();

        for (Employee e : list)
            System.out.println(registry.getEmployeeInfo(e)+"\n");
    }

    // RETURNS AND PRINTS THE NUMBER OF EMPLOYEES IN THE BUSINESS
    public void returnNumberOfEmployees(){
        System.out.println("\nThere are "+registry.returnNumOfEmployees()+" employees in the business.\n");
    }

    // MENU FOR THE SALES EMPLOYEES WHICH CARRIES OUT FUNCTIONS SPECIFIC TO THE SALES EMPLOYEES
    public void salesMenu(){
        int selection;

        // DISPLAYS A MENU USING PRINT STATEMENTS
        System.out.println("1. Sell product as sales person");
        System.out.println("2. Get sales from certain employee");
        System.out.println("3. Get all sales");
        System.out.println("4. Arrange meeting for a sales person");
        System.out.println("5. QUIT\n");

        // CALL METHODS CORRESPONDING TO THE USER INPUT WHILE INPUT IS WITHIN ACCEPTED RANGE
        do {
            selection = inputInt("Select an option: ");
        }while (selection < 1 || selection > 5);

        switch (selection){
            case 1:
                sellProduct();
                break;
            case 2:
                returnEmployeeSales();
                break;
            case 3:
                returnAllSales();
                break;
            case 4:
                meetCustomer();
            case 5:
                break;
        }
        return;
    }

    // METHOD THAT CHECKS IF THE ID INPUTTED CORRESPONDS TO A SALES EMPLOYEE
    public Employee validateSalesEmployee(){
        // GET THE ARRAYLIST OF SALES EMPLOYEES
        ArrayList<Employee> list = registry.returnSalesEmployees();
        int option;

        // ASKS TO ENTER THE ID OF THE EMPLOYEE AS LONG AS IT ISN'T -1
        do {
            int id = inputInt("Enter the id of the Sales employee: ");
            for (Employee e : list){
                if (e.getID() == id)
                    return e;
            }
            System.out.println("\nSales person with this id not found\n");
            option = inputInt("Select option 1 to try again or -1 to QUIT: ");
        }while (option != -1);

        return null;
    }

    // METHOD THAT SELLS A PRODUCT AS A SALES EMPLOYEE
    public void sellProduct(){
        Employee e = validateSalesEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, SELLS THE PRODUCT IN THAT EMPLOYEES NAME
        if (e == null) {
            return;
        }else
            registry.sellProduct((Sales) e);

        return;
    }

    // RETURNS ALL THE SALES FROM A CERTAIN SALES EMPLOYEE
    public void returnEmployeeSales(){
        Employee e = validateSalesEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, PRINTS THE NUMBER OF PRODUCTS SOLD
        if (e == null) {
            return;
        }else{
            String message = e.getName()+" has sold "+registry.returnEmployeeProductsSold((Sales) e)+" items.\n";
            System.out.println(message);
        }

        return;
    }

    // METHOD THAT RETURNS ALL SALES FOR THE BUSINESS
    public void returnAllSales(){
        int totalSales = registry.returnTotalProductsSold();
        System.out.println("Total sales of business is "+totalSales);

        return;
    }

    // METHOD THAT ALLOWS AN HR EMPLOYEE TO MEET A CUSTOMER
    public void meetCustomer(){
        Employee e = validateSalesEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, CALLS meetCustomer METHOD IN REGISTRY CLASS AS SALES OBJECT
        if (e == null) {
            return;
        }else
            registry.meetCustomer((Sales) e);

        return;
    }

    // MENU FOR THE HR EMPLOYEES WHICH CARRIES OUT FUNCTIONS SPECIFIC TO THE HR EMPLOYEES
    public void hrMenu(){
        int selection;

        // DISPLAYS A MENU USING PRINT STATEMENTS
        System.out.println("1. Hire employee as HR");
        System.out.println("2. Fire employee as HR");
        System.out.println("3. Give benefits as HR");
        System.out.println("4. QUIT\n");

        // CALL METHODS CORRESPONDING TO THE USER INPUT WHILE INPUT IS WITHIN ACCEPTED RANGE
        do {
            selection = inputInt("Select an option: ");
        }while (selection < 1 || selection > 4);

        switch (selection){
            case 1:
                hireEmployee();
                break;
            case 2:
                fireEmployee();
                break;
            case 3:
                giveBenefits();
                break;
            case 4:
                break;
        }
        return;
    }

    // METHOD THAT CHECKS IF THE ID INPUTTED CORRESPONDS TO A HR EMPLOYEE
    public Employee validateHrEmployee(){
        ArrayList<Employee> list = registry.returnHrEmployees();
        int option;

        // ASKS FOR USER INPUT AS LONG AS INPUT ISN'T -1, THEN VALIDATES INPUT AND RETURNS OBJECT ID
        do {
            int id = inputInt("Enter the id of the HR employee: ");
            for (Employee e : list){
                if (e.getID() == id)
                    return e;
            }
            System.out.println("\nHR person with this id not found\n");
            option = inputInt("Select option 1 to try again or -1 to QUIT: ");
        }while (option != -1);
        return null;
    }

    // METHOD THAT ALLOWS HR EMPLOYEE TO HIRE A NEW EMPLOYEE
    public void hireEmployee(){
        Employee e = validateHrEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, CALLS hireEmployee METHOD IN REGISTRY CLASS AS HR OBJECT
        if (e == null) {
            return;
        }else
            registry.hireEmployee((HR) e);
    }

    // METHOD THAT ALLOWS HR EMPLOYEE TO FIRE AN EMPLOYEE
    public void fireEmployee(){
        Employee e = validateHrEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, CALLS fireEmployee METHOD IN REGISTRY CLASS AS HR OBJECT
        if (e == null) {
            return;
        }else
            registry.fireEmployee((HR) e);

        return;
    }

    // METHOD THAT ALLOWS HR EMPLOYEE TO GIVE BENEFITS TO AN EMPLOYEE
    public void giveBenefits(){
        Employee e = validateHrEmployee();

        // RETURNS IF THE INPUT IS INVALID ELSE, CALLS giveBenefits METHOD IN REGISTRY CLASS AS HR OBJECT
        if (e == null) {
            return;
        }else
            registry.giveBenefits((HR) e);

        return;
    }

    public static void main(String[] args){

        // THIS MAIN METHOD INSTANCE IS USED TO REMOVE THE NEED TO USE STATIC METHODS IN THE MAIN CLASS
        Main myMain = new Main();

        int selection = 7;

        // CALL METHODS CORRESPONDING TO THE USER INPUT WHILE INPUT IS WITHIN ACCEPTED RANGE AND EXITS IF SELECTION = 7
        do {
            try {
                selection = myMain.menu();
                System.out.println();

                switch (selection){
                    case 1:
                        myMain.employSomeone();
                        break;
                    case 2:
                        myMain.changeManager();
                        break;
                    case 3:
                        myMain.getEmployeeInfo();
                        break;
                    case 4:
                        myMain.returnEmployeesMenu();
                        break;
                    case 5:
                        myMain.salesMenu();
                        break;
                    case 6:
                        myMain.hrMenu();
                        break;
                    case 7:
                        System.out.println("Thank you for using our services");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter an integer\n");
            }

        }while (selection != 7);

    }

}